package com.vilin.mybatis.chapter02.dao;

import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import com.vilin.mybatis.chapter02.mapper.RoleMapper2;
import com.vilin.mybatis.chapter02.po.Role;
import com.vilin.mybatis.util.MyBatisJavaConfigUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class RoleDao2 {
    public Role getRoleById(Long id){
        SqlSession sqlSession = MyBatisJavaConfigUtil.getSqlSessionFactory().openSession();
        RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
        return roleMapper2.getRole(id);
    }
}
