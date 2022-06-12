package com.su.service.impl;

import com.mysql.fabric.xmlrpc.base.Param;
import com.su.dao.DormitoryDao;
import com.su.dao.DormrepairDao;
import com.su.pojo.DormRepair;
import com.su.pojo.PageInfo;
import com.su.service.DormrepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DormrepairServiceimpl implements DormrepairService {
    @Autowired
    DormrepairDao dormrepairDao;

    @Override
    public PageInfo<DormRepair> findgetDormrepair(Integer d_id, String d_dormbuilding, Integer pageindex, Integer pagesize) {
        PageInfo pi=new PageInfo();
        int totalcount = dormrepairDao.totalcount(d_id, d_dormbuilding);
        pi.setTotalCount(totalcount);
        pi.setPageIndex(pageindex);
        pi.setPageSize(pagesize);
        System.out.println(pi.getPageIndex()+"=="+pi.getPageSize());
        List<DormRepair> dormRepair = dormrepairDao.getDormRepair(d_id, d_dormbuilding, (pi.getPageIndex() - 1) * pi.getPageSize(), pi.getPageSize());
        pi.setList(dormRepair);
        return pi;
    }


    @Override
    public int addDormRepair(DormRepair dormRepair) {
        int i = dormrepairDao.addDormRepair(dormRepair);
        return i;
    }

    @Override
    public DormRepair findDormRepairbyid(Integer r_id) {
        DormRepair dormRepairbyid = dormrepairDao.findDormRepairbyid(r_id);
        return dormRepairbyid;
    }

    @Override
    public int updateDormRepair(DormRepair dormRepair) {
        dormRepair.setUpdate_time(new Date());
        int i = dormrepairDao.updateDormRepair(dormRepair);
        return i;
    }

    @Override
    public int deleteDormRepair(Integer r_id) {
        int i = dormrepairDao.deleteDormRepair(r_id);
        return i;
    }

    @Override
    public List<DormRepair> getAll() {
        List<DormRepair> all = dormrepairDao.getAll();
        return all;
    }
}
