package com.su.service;

import com.su.pojo.DormRepair;
import com.su.pojo.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormrepairService {

    //分页查询
    public PageInfo<DormRepair> findgetDormrepair(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding,
                                                  @Param("pageindex") Integer pageindex,
                                                  @Param("pagesize") Integer pagesize);

    //添加
    public int addDormRepair(DormRepair dormRepair);
    //查询
    public DormRepair findDormRepairbyid(@Param("r_id")Integer r_id);
    //修改
    public int updateDormRepair(DormRepair dormRepair);
    //删除
    public int deleteDormRepair(@Param("r_id")Integer r_id);
    //查询全部
    public List<DormRepair> getAll();




}
