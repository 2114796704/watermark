package com.su.service;

import com.su.pojo.DormClean;
import com.su.pojo.PageInfo;
import com.su.pojo.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitorService {

    public PageInfo<Visitor>  getVisitor(@Param("v_name") String v_name, @Param("v_phone") Long v_phone,
                                         @Param("pageindex") Integer pageindex,
                                         @Param("pagesize") Integer pagesize);

    //添加
    public int addVisitor(Visitor visitor);

    //查询全部
    public List<Visitor> getAll();
}
