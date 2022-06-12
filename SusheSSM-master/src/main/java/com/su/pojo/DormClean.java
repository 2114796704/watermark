package com.su.pojo;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//宿舍卫生 ==>表 d_dormgrade

public class DormClean {
    private  Integer g_id;
    private  Integer d_id; // 宿舍编号，宿舍号301
    private  String  d_dormbuilding;//宿舍楼，多少号楼 24号楼
    private  Integer d_grade;//评分成绩
    //输出JSOn的时候格式化时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private   Date  create_time;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private   Date   update_time;

    public DormClean() {
    }

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_dormbuilding() {
        return d_dormbuilding;
    }

    public void setD_dormbuilding(String d_dormbuilding) {
        this.d_dormbuilding = d_dormbuilding;
    }

    public Integer getD_grade() {
        return d_grade;
    }

    public void setD_grade(Integer d_grade) {
        this.d_grade = d_grade;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "DormClean{" +
                "g_id=" + g_id +
                ", d_id=" + d_id +
                ", d_dormbuilding='" + d_dormbuilding + '\'' +
                ", d_grade=" + d_grade +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
