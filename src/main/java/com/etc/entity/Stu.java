package com.etc.entity;

import java.util.ArrayList;
import java.util.List;

public class Stu {
    private Integer sid;
    private String sname;
    private String sex;
    private String xueli;
    private Cla cla;
    private List<Linkman> list = new ArrayList<>();

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public Cla getCla() {
        return cla;
    }

    public void setCla(Cla cla) {
        this.cla = cla;
    }

    public List<Linkman> getList() {
        return list;
    }

    public void setList(List<Linkman> list) {
        this.list = list;
    }

    public Stu(Integer sid, String sname, String sex, String xueli, Cla cla, List<Linkman> list) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.xueli = xueli;
        this.cla = cla;
        this.list = list;
    }

    public Stu() {
    }
}
