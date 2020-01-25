package com.vilin.mybatis.chapter03.mapper;

import com.vilin.mybatis.chapter03.po.Role;

public interface RoleMapper {
    public Role getRole(Long id);
    public Role findRole(String roleName);
    public int insertRole(Role role);
    public int deleteRole(Long id);
}
