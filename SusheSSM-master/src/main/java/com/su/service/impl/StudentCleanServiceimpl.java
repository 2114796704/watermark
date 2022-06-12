package com.su.service.impl;

import com.su.dao.StudentCleanDao;
import com.su.pojo.PageInfo;
import com.su.pojo.StudentClean;
import com.su.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCleanServiceimpl implements StudentCleanService {
    @Autowired
    StudentCleanDao studentCleanDao;
    @Override
    public PageInfo<StudentClean> getStudentClean(Integer s_studentid, String s_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize) {
        PageInfo pi=new PageInfo();
        int count = studentCleanDao.totalCount(s_studentid, s_name, s_dormitoryid);
        pi.setTotalCount(count);
        pi.setPageSize(pageSize);
        pi.setPageIndex(pageIndex);
        List<StudentClean> studentClean = studentCleanDao.getStudentClean(s_studentid, s_name, s_dormitoryid, (pi.getPageIndex() - 1) * pi.getPageSize(), pi.getPageSize());
        pi.setList(studentClean);
        return pi;
    }

    @Override
    public int addStudentClean(StudentClean studentClean) {
        int i = studentCleanDao.addStudentClean(studentClean);
        return i;
    }

    @Override
    public StudentClean findStudentCleanbyid(Integer g_id) {
        StudentClean studentCleanbyid = studentCleanDao.findStudentCleanbyid(g_id);
        return studentCleanbyid;
    }

    @Override
    public int updateStudentClean(StudentClean studentClean) {
        int i = studentCleanDao.updateStudentClean(studentClean);
        return i;
    }

    @Override
    public int deleteStudentCleanbyid(Integer g_id) {
        int i = studentCleanDao.deleteStudentCleanbyid(g_id);
        return i;
    }

    @Override
    public List<StudentClean> getAll() {
        List<StudentClean> all = studentCleanDao.getAll();
        return all;
    }
}
