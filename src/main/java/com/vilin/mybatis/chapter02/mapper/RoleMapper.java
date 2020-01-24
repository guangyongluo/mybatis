package com.vilin.mybatis.chapter02.mapper;

import com.vilin.mybatis.chapter02.po.Role;

public interface RoleMapper {
    public Role getRole(Long id);
    public int insertRole(Role role);
    public int deleteRole(Long id);
}
