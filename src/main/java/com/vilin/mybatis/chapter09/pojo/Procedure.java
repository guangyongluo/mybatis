package com.vilin.mybatis.chapter09.pojo;

import java.util.Date;

public class Procedure {
    private String roleName = null;
    private int result = 0;
    private Date execDate;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }
}
