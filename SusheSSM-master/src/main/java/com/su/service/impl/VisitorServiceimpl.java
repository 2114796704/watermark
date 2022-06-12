package com.su.service.impl;

import com.su.dao.VisitorDao;
import com.su.pojo.PageInfo;
import com.su.pojo.Visitor;
import com.su.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceimpl implements VisitorService {
    @Autowired
    VisitorDao visitorDao;
    @Override
    public PageInfo<Visitor> getVisitor(String v_name, Long v_phone, Integer pageindex, Integer pagesize) {
        PageInfo<Visitor> pi=new PageInfo();
        int totalcount = visitorDao.totalcount(v_name, v_phone);
        pi.setTotalCount(totalcount);
        pi.setPageIndex(pageindex);
        pi.setPageSize(pagesize);
        List<Visitor> visitor = visitorDao.getVisitor(v_name, v_phone, (pi.getPageIndex() - 1) * pi.getPageSize(), pi.getPageSize());
        pi.setList(visitor);
        return pi;
    }

    @Override
    public int addVisitor(Visitor visitor) {
        int i = visitorDao.addVisitor(visitor);
        return i;
    }

    @Override
    public List<Visitor> getAll() {
        List<Visitor> all = visitorDao.getAll();
        return all;
    }
}
