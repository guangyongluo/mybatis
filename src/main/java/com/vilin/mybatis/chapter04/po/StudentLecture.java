package com.vilin.mybatis.chapter04.po;

import java.math.BigDecimal;

public class StudentLecture {
    private Long id;
    private Long studentId;
    private Lecture lecture;
    private BigDecimal grade;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "StudentLecture{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", lecture=" + lecture +
                ", grade=" + grade +
                ", note='" + note + '\'' +
                '}';
    }
}
