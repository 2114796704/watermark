package com.su.service;

import com.su.pojo.Class;
import com.su.pojo.PageInfo;
import com.su.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassService {

    //分页查询
    public PageInfo<Class> findgetClass(Integer c_classid, String c_classname, String c_counsellor,
                                        Integer pageIndex,
                                        Integer pageSize);
    //添加
    public int addClass(Class classs);

    //根据id查找班级
    public Class findClassbyid(Integer c_id);
    //修改
    public int updateClass(Class classs);

    //删除
    public int deleteClassbyid(Integer c_id);

    //联合查询==学生和班级表
    public List<Class> findClassStudent(@Param("c_classid") Integer c_classid,
                                        @Param("c_classname")String c_classname);//查询班级人员信息
    public List<Class> getAll();

}
