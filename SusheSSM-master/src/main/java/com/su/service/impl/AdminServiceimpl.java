package com.su.service.impl;

import com.su.dao.AdminDao;
import com.su.pojo.Admin;
import com.su.pojo.PageInfo;
import com.su.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
public class AdminServiceimpl  implements AdminService {

    @Autowired
   private AdminDao adminDao;

    @Override
    public Admin findAmin(Admin admin) {   //登录功能
         Admin a=adminDao.findAdmin(admin);

        return a;
    }

    @Override    //搜索加分页 查看管理员列表
    public PageInfo<Admin> findPageInfo(String a_username, String a_describe, Integer a_id, Integer pageIndex, Integer pageSize) {
      PageInfo<Admin>  pi=new PageInfo<Admin>();
      pi.setPageIndex(pageIndex); //从前端传入当前页码
      pi.setPageSize(pageSize); //从前端传入每页显示多少条数据
        //获取总条数
        Integer totalCount = adminDao.totalCount(a_username, a_describe, a_id);
        if (totalCount>0){
       pi.setTotalCount(totalCount);
       List<Admin> adminList = adminDao.getAdminList(a_username, a_describe, a_id, (pi.getPageIndex() - 1) * pi.getPageSize(), pi.getPageSize());
       pi.setList(adminList);
   }
        return pi;
    }

   //查看管理员信息--用于编辑
    public Admin findAdminById(Integer a_id){
        Admin  admin= adminDao.findAdminById(a_id);
        return admin;

    }

    @Override
    public int updateAdmin(Admin admin) {
        int i = adminDao.updateAdmin(admin);
        return i;
    }

    @Override
    public int addAdmin(Admin admin) {
        int i = adminDao.addAdmin(admin);
        return i;
    }

    @Override
    public int deleteAdmin(Integer a_id) {
        int i=adminDao.deleteAdmin(a_id);
        return i;
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> all = adminDao.getAll();
        return all;
    }


}
