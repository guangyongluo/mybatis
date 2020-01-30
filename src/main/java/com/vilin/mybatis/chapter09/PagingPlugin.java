package com.vilin.mybatis.chapter09;

import com.vilin.mybatis.chapter03.po.PageParams;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Intercepts({
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )
})
public class PagingPlugin implements Interceptor {

    private Integer defaultPage;//默认页码
    private Integer defaultPageSize;//默认每页条数
    private Boolean defaultUseFlag;//默认是否启用插件
    private Boolean defaultCheckFlag;//默认是否检查当前页码是否有效

    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = getUnProxyObject(invocation);
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        if(!checkSelect(sql)){
            return invocation.proceed();
        }
        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
        Object parameterObject = boundSql.getParameterObject();
        PageParams pageParams = getPageParams(parameterObject);
        if(pageParams == null){
            return invocation.proceed();
        }

        Integer pageNum = pageParams.getPage() == null ? this.defaultPage : pageParams.getPage();
        Integer pageSize = pageParams.getPageSize() == null ? this.defaultPageSize : pageParams.getPageSize();
        Boolean useFlag = pageParams.getUseFlag() == null ? this.defaultUseFlag : pageParams.getUseFlag();
        Boolean checkFlag = pageParams.getCheckFlag() == null ? this.defaultCheckFlag : pageParams.getCheckFlag();

        if(!useFlag){
            return invocation.proceed();
        }

        int total = getTotal(invocation, metaStatementHandler, boundSql);
        setTotalToPageParams(pageParams, total, pageSize);
        checkPage(checkFlag, pageNum, pageParams.getTotalPage());
        return changeSQL(invocation, metaStatementHandler, boundSql, pageNum, pageSize);
    }

    public Object plugin(Object target) {
        return null;
    }

    public void setProperties(Properties properties) {
        String strDefaultPage = properties.getProperty("default.page", "1");
        String strDefaultPageSize = properties.getProperty("default.pageSize", "50");
        String strDefaultUseFlag = properties.getProperty("default.UseFlag", "false");
        String strDefaultCheckFlag = properties.getProperty("default.checkFlag", "false");
        this.defaultPage = Integer.parseInt(strDefaultPage);
        this.defaultPageSize = Integer.parseInt(strDefaultPageSize);
        this.defaultUseFlag = Boolean.parseBoolean(strDefaultUseFlag);
        this.defaultCheckFlag = Boolean.parseBoolean(strDefaultCheckFlag);
    }

    private StatementHandler getUnProxyObject(Invocation invocation){
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        Object object = null;
        while(metaStatementHandler.hasGetter("h")){
            object = metaStatementHandler.getValue("h");
        }
        if(object == null){
            return statementHandler;
        }
        return (StatementHandler) object;
    }

    private boolean checkSelect(String sql){
        String trimSql = sql.trim();
        int index = trimSql.toLowerCase().indexOf("select");
        return index == 0;
    }

    private PageParams getPageParams(Object parameterObject){
        if(parameterObject == null){
            return null;
        }
        PageParams pageParams = null;
        if(parameterObject instanceof Map){
            Map<String, Object> paramMap = (Map<String, Object>)parameterObject;
            Set<String> keySet = paramMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while(iterator.hasNext()){
                String key = iterator.next();
                Object value = paramMap.get(key);
                if(value instanceof PageParams){
                    return (PageParams)value;
                }
            }
        }else if(parameterObject instanceof PageParams){
            pageParams = (PageParams)parameterObject;
        }
        return pageParams;
    }

    private int getTotal(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql){
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        Configuration configuration = mappedStatement.getConfiguration();
        String sql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");
        String countSql = "select count(*) as total from (" + sql + ") $_paging";
        Connection connection = (Connection)invocation.getArgs()[0];
        PreparedStatement ps = null;
        int total = 0;
        try{
            ps = connection.prepareStatement(countSql);
            BoundSql countBoundSql = new BoundSql(configuration, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            ParameterHandler handler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
            handler.setParameters(ps);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                total = rs.getInt("total");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("总条数" + total);
        return total;
    }

    private void setTotalToPageParams(PageParams pageParams, int total, int pageSize){
        pageParams.setTotal(total);
        int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        pageParams.setTotalPage(totalPage);
    }

    private void checkPage(Boolean checkFlag, Integer pageNum, Integer pageTotal) throws Exception{
        if(checkFlag){
            if(pageNum > pageTotal){
                throw new Exception("查询失败，查询页码【" + pageNum + "】大于总页数【" + pageTotal + "】！！！");
            }
        }
    }

    private Object changeSQL(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql, int page, int pageSize){
        String sql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");
        String newSql = "select * from (" + sql + ") $_paging_table limit ?, ?";
        metaStatementHandler.setValue("delegate.boundSql.sql", newSql);
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement)invocation.proceed();
            int count = ps.getParameterMetaData().getParameterCount();
            ps.setInt(count - 1, (page - 1) * pageSize);
            ps.setInt(count, pageSize);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
}
