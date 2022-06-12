package com.su.service.impl;

import com.su.dao.DormCleanDao;
import com.su.pojo.DormClean;
import com.su.pojo.PageInfo;
import com.su.service.DormCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormCleanServiceimpl implements DormCleanService {
    @Autowired
    DormCleanDao dormCleanDao;
    @Override
    public PageInfo<DormClean> findgetDormClean(Integer d_id, String d_dormbuilding, Integer pageindex, Integer pagesize) {
        PageInfo pi=new PageInfo();
        int totalcount = dormCleanDao.totalcount(d_id, d_dormbuilding);
         pi.setTotalCount(totalcount);
         pi.setPageIndex(pageindex);
         pi.setPageSize(pagesize);
        List<DormClean> dormClean = dormCleanDao.getDormClean(d_id, d_dormbuilding, (pi.getPageIndex() - 1) * pi.getPageSize(), pi.getPageSize());
        pi.setList(dormClean);
        return pi;
    }

    @Override
    public int addDormClean(DormClean dormClean) {
        int i = dormCleanDao.addDormClean(dormClean);
        return i;
    }

    @Override
    public DormClean findDormCleanbyid(Integer g_id) {
        DormClean dormCleanbyid = dormCleanDao.findDormCleanbyid(g_id);
        return dormCleanbyid;
    }

    @Override
    public int updateDormClean(DormClean dormClean) {
        int i = dormCleanDao.updateDormClean(dormClean);
        return i;
    }

    @Override
    public int deleteDormClean(Integer g_id) {
        int i = dormCleanDao.deleteDormClean(g_id);
        return i;
    }

    @Override
    public List<DormClean> getAll() {
        List<DormClean> all = dormCleanDao.getAll();
        return all;
    }
}
