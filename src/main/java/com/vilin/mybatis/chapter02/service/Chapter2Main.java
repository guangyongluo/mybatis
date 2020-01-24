package com.vilin.mybatis.chapter02.service;

import com.vilin.mybatis.chapter02.mapper.RoleMapper;
import com.vilin.mybatis.chapter02.po.Role;
import com.vilin.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter2Main {
    private static Logger logger = Logger.getLogger(SqlSessionFactoryUtil.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            Role role = new Role();
//            role.setRoleName("testUser");
//            role.setNote("测试用户");
//            roleMapper.insertRole(role);
//            System.out.println(roleMapper.getRole(3L));
            roleMapper.deleteRole(3L);
            sqlSession.commit();
        }catch (Exception e){
            logger.log(Level.INFO, null, e);
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
