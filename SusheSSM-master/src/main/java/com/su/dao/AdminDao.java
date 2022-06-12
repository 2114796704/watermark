package com.su.dao;

import com.su.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AdminDao {
    public Admin findAdmin(Admin admin);//通过账号和密码查询管理员；1.登录功能

    //获取总条数
   public  Integer totalCount(@Param("a_username") String a_username, @Param("a_describe") String a_describe,@Param("a_id") Integer a_id);

    //查询管理员  第一次查询，搜索内容为null,所以是查询全部）
    public List<Admin> getAdminList(@Param("a_username") String a_username,
                                    @Param("a_describe") String a_describe,
                                    @Param("a_id") Integer a_id,
                                    @Param("currentPage") Integer currentPage,
                                    @Param("pageSize") Integer pageSize);

    //根据a_id查询管理员
    public Admin  findAdminById(@Param("a_id")Integer a_id);
   //修改管理员信息
    public int  updateAdmin(Admin admin);

    //添加管理员
    public int addAdmin(Admin admin);
    //删除管理员
    public int deleteAdmin(Integer a_id);
    //查询全部管理员---用于导出功能
    public List<Admin> getAll();



}
