package com.vilin.mybatis.chapter02.service;

import com.vilin.mybatis.chapter02.mapper.RoleMapper;
import com.vilin.mybatis.chapter02.po.Role;
import com.vilin.mybatis.chapter04.service.Chapter4Main;
import com.vilin.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chapter2Main {
    private static Logger logger = LogManager.getLogger(Chapter4Main.class);

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
            logger.info(e);
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
