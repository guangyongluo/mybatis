package com.vilin.mybatis.chapter04.po;

import java.util.List;

public class MaleStudent extends Student {
    private List<StudentHealthMale> studentHealthMaleList = null;

    public List<StudentHealthMale> getStudentHealthMaleList() {
        return studentHealthMaleList;
    }

    public void setStudentHealthMaleList(List<StudentHealthMale> studentHealthMaleList) {
        this.studentHealthMaleList = studentHealthMaleList;
    }

    @Override
    public String toString() {
        return super.toString() + "MaleStudent{" +
                "studentHealthMaleList=" + studentHealthMaleList +
                '}';
    }
}
