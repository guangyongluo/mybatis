package com.vilin.mybatis.chapter04.mapper;

import com.vilin.mybatis.chapter04.po.StudentHealthMale;

import java.util.List;

public interface StudentHealthMaleMapper {
    public List<StudentHealthMale> findStudentHealthMaleByStudentId(int id);
}
