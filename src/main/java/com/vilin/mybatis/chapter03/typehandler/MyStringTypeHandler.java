package com.vilin.mybatis.chapter03.typehandler;

import com.sun.istack.internal.logging.Logger;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyStringTypeHandler implements TypeHandler<String> {
    private static Logger log = Logger.getLogger(MyStringTypeHandler.class);

    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        log.info("使用我的TypeHandler");
        preparedStatement.setString(i, s);
    }

    public String getResult(ResultSet resultSet, String s) throws SQLException {
        log.info("使用我的TypeHandler, ResultSet列名获得字符串");
        return resultSet.getString(s);
    }

    public String getResult(ResultSet resultSet, int i) throws SQLException {
        log.info("使用我的TypeHandler, ResultSet索引获得字符串");
        return resultSet.getString(i);
    }

    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        log.info("使用我的TypeHandler, CallableStatement索引获得字符串");
        return callableStatement.getString(i);
    }
}
