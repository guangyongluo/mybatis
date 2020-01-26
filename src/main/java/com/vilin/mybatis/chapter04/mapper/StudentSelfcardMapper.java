package com.vilin.mybatis.chapter04.mapper;

import com.vilin.mybatis.chapter04.po.StudentSelfcard;

public interface StudentSelfcardMapper {
    public StudentSelfcard findStudentSelfcardByStudentId(int studentId);
}
