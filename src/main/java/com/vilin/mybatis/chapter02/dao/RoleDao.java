package com.vilin.mybatis.chapter02.dao;

import com.vilin.mybatis.chapter02.mapper.RoleMapper;
import com.vilin.mybatis.chapter02.po.Role;
import com.vilin.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class RoleDao {

    public Role getRoleById(Long id){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        return roleMapper.getRole(1L);
    }

}
