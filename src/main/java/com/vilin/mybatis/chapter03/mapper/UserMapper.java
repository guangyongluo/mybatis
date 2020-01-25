package com.vilin.mybatis.chapter03.mapper;

import com.vilin.mybatis.chapter03.po.User;

public interface UserMapper {
    public User getUser(Long id);
    public int insertUser(User user);
}
