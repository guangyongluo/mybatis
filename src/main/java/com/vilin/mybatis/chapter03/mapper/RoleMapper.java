package com.vilin.mybatis.chapter03.mapper;

import com.vilin.mybatis.chapter03.po.Role;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface RoleMapper {
    public Role getRole(Long id);
    public Role findRole(String roleName);
    public int insertRole(Role role);
    public int deleteRole(Long id);
    public List<Role> findRolesByName(String roleName, RowBounds rowBounds);
}
