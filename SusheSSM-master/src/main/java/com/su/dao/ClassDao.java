package com.su.dao;

import com.su.pojo.Class;
import com.su.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//班级管理
public interface ClassDao {

    //获取总条数,如果存在条件班级编号，班级名，辅导员名
    public int totalCount(@Param("c_classid") Integer c_classid,
                          @Param("c_classname")String c_classname,
                          @Param("c_counsellor") String c_counsellor);

    //分页查询，当前页编号， 每页大小
    public List<Class> getClass(@Param("c_classid")Integer c_classid,@Param("c_classname")String c_classname,@Param("c_counsellor")String c_counsellor,
                                @Param("pageIndex") Integer pageIndex,
                                @Param("pageSize") Integer pageSize);

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
//查询全部，用于导出
    public List<Class> getAll();

}
