package com.vilin.mybatis.chapter04.po;

import com.vilin.mybatis.chapter03.util.Sex;

import java.util.List;

public class Student {
    private Long id;
    private String cnname;
    private Sex sex;
    private String note;
    private StudentSelfcard studentSelfcard;
    private List<StudentLecture> studentLectureList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public StudentSelfcard getStudentSelfcard() {
        return studentSelfcard;
    }

    public void setStudentSelfcard(StudentSelfcard studentSelfcard) {
        this.studentSelfcard = studentSelfcard;
    }

    public List<StudentLecture> getStudentLectureList() {
        return studentLectureList;
    }

    public void setStudentLectureList(List<StudentLecture> studentLectureList) {
        this.studentLectureList = studentLectureList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", cnname='" + cnname + '\'' +
                ", sex=" + sex +
                ", note='" + note + '\'' +
                ", studentSelfcard=" + studentSelfcard +
                ", studentLectureList=" + studentLectureList +
                '}';
    }
}
