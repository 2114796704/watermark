package com.su.dao;


import com.su.pojo.Dormitory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//核酸检测站点管理
public interface DormitoryDao {
    //查询核酸站点总数
    public Integer totalCount(@Param("s_dormitoryid")Integer s_dormitoryid,
                          @Param("d_dormbuilding")Integer d_dormbuilding,
                          @Param("a_name")Integer a_name);
    //查询核酸站点信息
    public List<Dormitory> getDormitory(@Param("s_dormitoryid")Integer s_dormitoryid,
                                       @Param("d_dormbuilding")Integer d_dormbuilding,
                                       @Param("a_name")Integer a_name,
                                        @Param("pageIndex") Integer pageIndex,
                                        @Param("pageSize") Integer pageSize);

    //添加核酸站点
    public  Integer addDormitory(Dormitory dormitory);
    //根据id查询宿舍
    public  Dormitory findDormitorybyid(Integer d_id);
    //修改核酸站点
     public  Integer updateDormitory(Dormitory dormitory);
    //删除核酸站点
    public  Integer deleteDormitorybyid(Integer d_id);
    //查询全部核酸站点
    public List<Dormitory> getAll();
   //联合查询
    public List<Dormitory>  findDormitoryStudent(@Param("s_dormitoryid") Integer s_dormitoryid);

}
