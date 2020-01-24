package com.vilin.mybatis.chapter02.service;

import com.vilin.mybatis.chapter02.dao.RoleDao;
import com.vilin.mybatis.chapter02.dao.RoleDao2;

public class RoleService {

    private RoleDao roleDao = new RoleDao();

    private RoleDao2 roleDao2 = new RoleDao2();

    public void printRoleNameById(){
        System.out.println(roleDao.getRoleById(1L));
        System.out.println(roleDao2.getRoleById(2L));
    }

    public static void main(String[] args) {
        RoleService roleService = new RoleService();
        roleService.printRoleNameById();
    }
}
