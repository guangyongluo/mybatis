package com.vilin.mybatis.chapter04.mapper;

import com.vilin.mybatis.chapter04.po.StudentHealthFemale;

import java.util.List;

public interface StudentHealthFemaleMapper {
    public List<StudentHealthFemale> findStudentHealthFemaleByStudentId(int id);
}
