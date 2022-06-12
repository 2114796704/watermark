package com.su.service.impl;

import com.su.dao.ClassDao;
import com.su.pojo.Class;
import com.su.pojo.PageInfo;
import com.su.pojo.Student;
import com.su.service.ClassService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ClassServiceimpl implements ClassService {
    @Autowired
    ClassDao classDao;


    @Override
    public PageInfo<Class> findgetClass(Integer c_classid, String c_classname, String c_counsellor,
                                        Integer pageIndex, Integer pageSize) {
        PageInfo<Class> pi=new PageInfo<>();
        int count = classDao.totalCount(c_classid,c_classname,c_counsellor);
        pi.setTotalCount(count);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        List<Class> aClass = classDao.getClass(c_classid, c_classname, c_counsellor, (pi.getPageIndex()-1)*pi.getPageSize(), pi.getPageSize());
        pi.setList(aClass);
        return pi;

    }


    @Override
    public int addClass(Class classs) {
        int i = classDao.addClass(classs);
        return i;
    }

    @Override
    public Class findClassbyid(Integer c_id) {
        Class classbyid = classDao.findClassbyid(c_id);
        return classbyid;
    }

    @Override
    public int updateClass(Class classs) {
        int i = classDao.updateClass(classs);
        return i;
    }

    @Override
    public int deleteClassbyid(Integer c_id) {
        int i = classDao.deleteClassbyid(c_id);
        return i;
    }

    @Override
    public List<Class> findClassStudent( Integer c_classid,
                                        String c_classname) {
        List<Class> classStudent = classDao.findClassStudent(c_classid,c_classname);
        return classStudent;
    }

    @Override
    public List<Class> getAll() {
        List<Class> all = classDao.getAll();
        return all;
    }
}
