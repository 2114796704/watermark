package com.su.pojo;

import java.io.Serializable;
import java.util.List;

//宿舍信息表
public class Dormitory  implements Serializable {
     private static final long  serialVersionUID=1L;
     private  Integer d_id;
     private  Integer s_dormitoryid;//宿舍编号
     private  String d_dormbuilding;//宿舍楼
     private  String d_bedtotal;//床的总数
     private  String d_bed; //剩余床数
     private String  a_name;//宿舍管理员

    private List<Student> students;//宿舍的同学

    public Dormitory() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Integer getS_dormitoryid() {
        return s_dormitoryid;
    }

    public void setS_dormitoryid(Integer d_dormitoryid) {
        this.s_dormitoryid = d_dormitoryid;
    }

    public String getD_dormbuilding() {
        return d_dormbuilding;
    }

    public void setD_dormbuilding(String d_dormbuilding) {
        this.d_dormbuilding = d_dormbuilding;
    }

    public String getD_bedtotal() {
        return d_bedtotal;
    }

    public void setD_bedtotal(String d_bedtotal) {
        this.d_bedtotal = d_bedtotal;
    }

    public String getD_bed() {
        return d_bed;
    }

    public void setD_bed(String d_bed) {
        this.d_bed = d_bed;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "d_id=" + d_id +
                ", d_dormitoryid=" + s_dormitoryid +
                ", d_dormbuilding='" + d_dormbuilding + '\'' +
                ", d_bedtotal='" + d_bedtotal + '\'' +
                ", d_bed='" + d_bed + '\'' +
                ", a_name='" + a_name + '\'' +
                ", students=" + students +
                '}';
    }
}
