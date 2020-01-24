package com.vilin.mybatis.chapter02.mapper;

import com.vilin.mybatis.chapter02.po.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper2 {

    @Select(value = "select id, role_name as roleName, note from t_role where id = #{id}")
    public Role getRole(Long id);
}
