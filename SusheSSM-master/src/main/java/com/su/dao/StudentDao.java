package com.su.dao;

import com.su.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    /*
     * 分页查询学生
     * 1.查询总记录
     * 2.根据 每页大小pagesize和当前页currentPage获取用户
     * */

    //1.查询总记录
    public Integer totalCount( @Param("s_name") String s_name,
         @Param("s_studentid") Integer s_studentid,
          @Param("s_classid")Integer s_classid,
          @Param("s_classname") String s_classname);

    //2.根据 每页大小pagesize和当前页currentPage获取用户
    public List<Student>  getStudent(
             @Param("s_name") String s_name,
             @Param("s_studentid") Integer s_studentid,
             @Param("s_classid")Integer s_classid,
             @Param("s_classname") String s_classname,
             @Param("currentPage")Integer currentPage,
             @Param("pageSize")Integer pageSize

    );

//添加学生
    public int addStudent(Student student);

//根据id查找学生
    public Student findStudentbyid(Integer s_id);

//修改学生
    public int updateStudent(Student student);
//删除学生
    public  int  deleteStudentbyid(int s_id);
}
