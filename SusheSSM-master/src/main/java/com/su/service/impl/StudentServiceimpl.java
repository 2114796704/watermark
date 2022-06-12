package com.su.service.impl;


import com.su.dao.StudentDao;
import com.su.pojo.PageInfo;
import com.su.pojo.Student;
import com.su.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service("studentService")
public class StudentServiceimpl implements StudentService {

        @Autowired
       StudentDao studentDao;

    @Override
    public PageInfo<Student> findgetStudent(String s_name, Integer s_studentid, Integer s_classid, String s_classname, Integer pageIndex, Integer pageSize) {
         PageInfo<Student> pi=new PageInfo<>();
         //获取总数
        Integer totalCount = studentDao.totalCount(s_name, s_studentid, s_classid, s_classname);
        //设置总数
         pi.setTotalCount(totalCount);
        //设置当前为第几页
        pi.setPageIndex(pageIndex);
        //设置每页显示多少数据
        pi.setPageSize(pageSize);
        //把学生放入list
        List<Student> student = studentDao.getStudent(s_name, s_studentid, s_classid, s_classname, (pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageSize());
         pi.setList(student);
        return pi;
    }

    @Override
    public int addStudent(Student student) {
        int i = studentDao.addStudent(student);
        return i;
    }

    @Override
    public Student findStudentbyid(Integer s_id) {
        Student student = studentDao.findStudentbyid(s_id);
        return student;
    }

    @Override
    public int updateStudent(Student student) {
        int i = studentDao.updateStudent(student);
        return i;
    }

    @Override
    public int deleteStudentbyid(int s_id) {
        int i = studentDao.deleteStudentbyid(s_id);
        return i;
    }


}
