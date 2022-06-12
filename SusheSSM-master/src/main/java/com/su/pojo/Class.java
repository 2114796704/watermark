package com.su.pojo;

import java.util.List;

//专业信息表
public class Class {
    private  Integer c_id;
    private  Integer c_classid;//专业号
    private  String  c_classname;//专业名称
    private  String  c_counsellor;//辅导员
    //班级与学生是多对一的关系，使用集合
    private List<Student> students;

    public Class() {
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getC_classid() {
        return c_classid;
    }

    public void setC_classid(Integer c_classid) {
        this.c_classid = c_classid;
    }

    public String getC_classname() {
        return c_classname;
    }

    public void setC_classname(String c_classname) {
        this.c_classname = c_classname;
    }

    public String getC_counsellor() {
        return c_counsellor;
    }

    public void setC_counsellor(String c_counsellor) {
        this.c_counsellor = c_counsellor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class{" +
                "c_id=" + c_id +
                ", c_classid=" + c_classid +
                ", c_classname='" + c_classname + '\'' +
                ", c_counsellor='" + c_counsellor + '\'' +
                ", students=" + students +
                '}';
    }
}
