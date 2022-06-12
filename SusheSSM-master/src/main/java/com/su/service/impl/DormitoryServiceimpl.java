package com.su.service.impl;

import com.su.dao.DormitoryDao;
import com.su.pojo.Dormitory;
import com.su.pojo.PageInfo;
import com.su.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryServiceimpl implements DormitoryService {
    @Autowired
    DormitoryDao dormitoryDao;
    @Override
    public PageInfo<Dormitory> findDormitory(Integer s_dormitoryid, Integer d_dormbuilding, Integer a_name, Integer pageIndex, Integer pageSize) {
        PageInfo pi =new PageInfo();
        Integer totalCount = dormitoryDao.totalCount(s_dormitoryid, d_dormbuilding, a_name);
        pi.setTotalCount(totalCount);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        List<Dormitory> dormitory = dormitoryDao.getDormitory(s_dormitoryid, d_dormbuilding, a_name, (pi.getPageIndex() - 1) * pi.getPageSize(), pi.getPageSize());
        pi.setList(dormitory);
        return pi;
    }

    @Override
    public Integer addDormitory(Dormitory dormitory) {
        Integer integer = dormitoryDao.addDormitory(dormitory);
        return null;
    }

    @Override
    public Dormitory findDormitorybyid(Integer d_id) {
        Dormitory dormitorybyid = dormitoryDao.findDormitorybyid(d_id);
        return dormitorybyid;
    }

    @Override
    public Integer updateDormitory(Dormitory dormitory) {
        Integer integer = dormitoryDao.updateDormitory(dormitory);
        return integer;
    }

    @Override
    public int  deleteDormitorybyid(Integer d_id) {
        Integer integer = dormitoryDao.deleteDormitorybyid(d_id);
        return integer;
    }

    @Override
    public List<Dormitory> getAll() {
        List<Dormitory> all = dormitoryDao.getAll();
        return all;
    }
    public List<Dormitory>  findDormitoryStudent(Integer s_dormitoryid){
        List<Dormitory> dormitoryStudent = dormitoryDao.findDormitoryStudent(s_dormitoryid);
        return dormitoryStudent;
    }
}
