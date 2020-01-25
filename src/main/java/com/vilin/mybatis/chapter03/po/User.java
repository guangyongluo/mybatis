package com.vilin.mybatis.chapter03.po;

import com.vilin.mybatis.chapter03.util.Sex;

public class User {
    private Long id;
    private String userName;
    private String cnname;
    private Sex sex;
    private String mobile;
    private String email;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", cnname='" + cnname + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
