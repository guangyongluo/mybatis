package com.vilin.mybatis.chapter04.po;

import java.util.List;

public class FemaleStudent extends Student {
    private List<StudentHealthFemale> studentHealthFemaleList = null;

    public List<StudentHealthFemale> getStudentHealthFemaleList() {
        return studentHealthFemaleList;
    }

    public void setStudentHealthFemaleList(List<StudentHealthFemale> studentHealthFemaleList) {
        this.studentHealthFemaleList = studentHealthFemaleList;
    }
}
