package com.su.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;


//、管理员表
public class Admin {

    // @JsonIgnore 一般标记在属性或者方法上，返回的json数据即不包含该属性。

    private  Integer a_id;
    private  String  a_username; //用户名
    private  String  a_password;//密码
    private  String   a_name;  //姓名
    //有一个小问题，Integer最大只能到十位数，所以到达10位以上可能会出现400错误
    //发现这个错误，改用long
    private  long  a_phone;//电话,
    private  Integer  a_power;
    private String    a_describe;


    public Admin() {
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getA_username() {
        return a_username;
    }

    public void setA_username(String a_username) {
        this.a_username = a_username;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public long getA_phone() {
        return a_phone;
    }

    public void setA_phone(long a_phone) {
        this.a_phone = a_phone;
    }

    public Integer getA_power() {
        return a_power;
    }

    public void setA_power(Integer a_power) {
        this.a_power = a_power;
    }

    public String getA_describe() {
        return a_describe;
    }

    public void setA_describe(String a_describe) {
        this.a_describe = a_describe;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_id=" + a_id +
                ", a_username='" + a_username + '\'' +
                ", a_password='" + a_password + '\'' +
                ", a_name='" + a_name + '\'' +
                ", a_phone=" + a_phone +
                ", a_power=" + a_power +
                ", a_describe='" + a_describe + '\'' +
                '}';
    }
}
