package com.su.service;

import com.su.pojo.PageInfo;
import com.su.pojo.Student;

import java.util.List;

public interface StudentService {


     //分页查询
  public PageInfo<Student> findgetStudent(String s_name, Integer s_studentid, Integer s_classid,
                                        String s_classname, Integer pageIndex, Integer pageSize);

    //添加学生
    public int addStudent(Student student);
    //根据id查找学生
    public Student findStudentbyid(Integer s_id);
    //修改学生
    public int updateStudent(Student student);
    //删除学生
    public  int  deleteStudentbyid(int s_id);
}
