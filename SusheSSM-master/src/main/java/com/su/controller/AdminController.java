package com.su.controller;

import com.su.pojo.Admin;
import com.su.pojo.PageInfo;
import com.su.service.AdminService;
import com.su.util.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    private AdminService adminService ;

     //登录功能 账号 zxk  密码 zxk123
    @RequestMapping(value = "/login")
    public  String Login(Model model, Admin admin, HttpSession session){
        //把密码加密再判断
       admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        Admin  ad= adminService.findAmin(admin);
          if (ad!=null){
              session.setAttribute("ad",ad);//把用户加入session
           return "homepage";
          }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }


    //退出功能
    @RequestMapping(value = "/loginOut")
    public  String LoginOut(HttpSession session){
       session.invalidate();
         return "login";
    }

//查看管理员（分页+搜索）
    /**
     *
     * @param a_username：管理员名字
     * @param a_describe：管理员级别
     * @param pageIndex  :用来分页
     * @param a_id：管理员id
     * @param pageSize :显示条数
     * @param model
     * @return
     */
    @RequestMapping("/findAdmin")
 public String findAdmin(String a_username, String a_describe, Integer pageIndex,
                         Integer a_id , Integer pageSize, Model model,HttpSession session){
        PageInfo<Admin> pageInfo = adminService.findPageInfo(a_username, a_describe, a_id, pageIndex, pageSize);
        model.addAttribute("ai",pageInfo);
        if (a_username!=null && !a_username.trim().equals("")){
            model.addAttribute("a_username",a_username);
        }
        if (a_describe!=null && !a_describe.trim().equals("")){
            model.addAttribute("a_describe",a_describe);
        }
        return "admin/admin_list";
}

//添加管理员功能
    @RequestMapping("/addAdmin")
  public String addAdmin(@RequestBody Admin admin){
        /*
        *遇到两个问题
        * 1.前端传的是JSon,利用@RequestBody返回admin
         * 2.发现主键为null,即管理员id=null  这个不是错误原因不加也行，但是突然学到了两个参数
         * 需要使用mybatis在xml中的 keyProperty="a_id" useGeneratedKeys="true"
        * */

        //加密密码
        admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        int i = adminService.addAdmin(admin);
        return "admin/admin_list";

    }



//编辑管理员信息==>第一步先根据id查询信息
    @RequestMapping("findAdminById")
public String findAdminById(Integer a_id,HttpSession session){
        Admin adminById = adminService.findAdminById(a_id);
        session.setAttribute("a",adminById);
        return "admin/admin_edit";
}
//==>第二步修改管理信息
    @RequestMapping("/updateAdmin")
    public  String updateAdmin(Admin admin, HttpServletRequest request,HttpServletResponse response) throws IOException {
        //把密码md5加密==注意判断一下密码是否修改，如果没修改就不用加密了
        String pass=adminService.findAdminById(admin.getA_id()).getA_password();
        if (!admin.getA_password().equals(pass)){
            //密码变动，加密
            System.out.println("密码修改===>");
            admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        }
        int i = adminService.updateAdmin(admin);
        //遇到第一个小问题，pojo中手机号是Integer，而最大只能到十位数，所以到达10位以上可能会出现400错误
        //解决办法，修改手机号为long
       request.getSession().setAttribute("edit_sucess","修改成功");
            return "redirect:/findAdmin";

    }

//删除管理员
    @RequestMapping("/deleteAdmin")
   public String deleteAdmin(@RequestParam("a_id") Integer id){
        int i = adminService.deleteAdmin(id);

        return "admin/admin_list";
    }

  //导出管理员
    /*
    * 1.查询全部管理员生成一个集合
    * 2.把集合生成json传递个前端
    *
    * */
  @RequestMapping("/exportadminlist")
  @ResponseBody
  public List<Admin>   exportadminlist(){
      List<Admin> all = adminService.getAll();
      return all;
  }

}
