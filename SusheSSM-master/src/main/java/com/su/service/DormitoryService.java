package com.su.service;

import com.su.pojo.Dormitory;
import com.su.pojo.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormitoryService {
    //分页显示宿舍
    public PageInfo<Dormitory>  findDormitory(@Param("s_dormitoryid")Integer s_dormitoryid,
                                              @Param("d_dormbuilding")Integer d_dormbuilding,
                                              @Param("a_name")Integer a_name,
                                              @Param("pageIndex") Integer pageIndex,
                                              @Param("pageSize") Integer pageSize);

    //添加宿舍
    public  Integer addDormitory(Dormitory dormitory);
    //根据id查询宿舍
    public  Dormitory findDormitorybyid(Integer d_id);
    //修改宿舍
    public  Integer updateDormitory(Dormitory dormitory);
    //删除宿舍
    public  int deleteDormitorybyid(Integer d_id);
    //查询全部宿舍
    public List<Dormitory> getAll();

    public List<Dormitory>  findDormitoryStudent(Integer s_dormitoryid);



}
