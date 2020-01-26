package com.vilin.mybatis.chapter03.service;

import com.vilin.mybatis.chapter03.mapper.RoleMapper;
import com.vilin.mybatis.chapter03.mapper.UserMapper;
import com.vilin.mybatis.chapter03.po.User;
import com.vilin.mybatis.chapter03.util.Sex;
import com.vilin.mybatis.chapter04.service.Chapter4Main;
import com.vilin.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chapter3Main {

    private static Logger logger = LogManager.getLogger(Chapter4Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
//            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            Role role = new Role();
//            role.setRoleName("testUser");
//            role.setNote("测试用户");
//            roleMapper.insertRole(role);
//            System.out.println(roleMapper.getRole(2L));

//            System.out.println(roleMapper.findRole("ad"));

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUserName("小黑");
            user.setCnname("罗葳");
            user.setSex(Sex.MALE);
            user.setMobile("123456789");
            user.setEmail("123456789@163.com");
            user.setNote("测试用户");
            userMapper.insertUser(user);
            System.out.println(userMapper.getUser(1L));
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
