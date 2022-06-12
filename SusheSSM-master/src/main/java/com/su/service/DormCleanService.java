package com.su.service;

import com.su.pojo.DormClean;
import com.su.pojo.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormCleanService {

    public PageInfo<DormClean> findgetDormClean(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding,
                                                @Param("pageindex") Integer pageindex,
                                                @Param("pagesize") Integer pagesize);

    //添加
    public int addDormClean(DormClean dormClean);
    //查询
    public DormClean findDormCleanbyid(@Param("g_id")Integer g_id);
    //修改
    public int updateDormClean(DormClean dormClean);
    //删除
    public int deleteDormClean(@Param("g_id")Integer g_id);
    //查询全部
    public List<DormClean> getAll();


}
