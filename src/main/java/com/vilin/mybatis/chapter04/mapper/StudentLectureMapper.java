package com.vilin.mybatis.chapter04.mapper;

import com.vilin.mybatis.chapter04.po.StudentLecture;

import java.util.List;

public interface StudentLectureMapper {
    public List<StudentLecture> findStudentLectureByStudentId();
}
