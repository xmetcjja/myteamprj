package com.etc.entity;

public class Linkman {
    private Integer lid;
    private String lname;
    private String ltel;
    private Stu stu;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLtel() {
        return ltel;
    }

    public void setLtel(String ltel) {
        this.ltel = ltel;
    }

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    public Linkman(Integer lid, String lname, String ltel, Stu stu) {
        this.lid = lid;
        this.lname = lname;
        this.ltel = ltel;
        this.stu = stu;
    }

    public Linkman() {
    }
}
