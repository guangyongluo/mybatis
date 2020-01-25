package com.vilin.mybatis.chapter03.dao;

import com.vilin.mybatis.chapter03.mapper.RoleMapper;
import com.vilin.mybatis.chapter03.po.Role;
import com.vilin.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class RoleDao {

    public Role getRoleById(Long id){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        return roleMapper.getRole(id);
    }

}
