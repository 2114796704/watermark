package com.su.service;

import com.su.pojo.Admin;
import com.su.pojo.PageInfo;

import java.util.List;

public interface AdminService {
    public Admin  findAmin(Admin admin);//通过账号和密码查询用户;(1)登录功能
    public PageInfo<Admin> findPageInfo(String a_username, String a_describe,Integer a_id, Integer pageIndex, Integer pageSize);//分页查看全部和搜索管理员
    public Admin findAdminById(Integer a_id);//根据id查询管理员信息
    public int updateAdmin(Admin admin);//修改管理员信息
    public int addAdmin(Admin admin);//添加管理员
    public int deleteAdmin(Integer a_id);//删除管理员
    public List<Admin> getAll();    //查询全部管理员---用于导出功能
}
