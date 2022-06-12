package com.su.controller;

import com.su.pojo.Dormitory;
import com.su.pojo.PageInfo;
import com.su.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DormitoryController {
   @Autowired
    DormitoryService dormitoryService;

    @RequestMapping("/findDormitory")
    public String findDormitory(Integer s_dormitoryid, Integer d_dormbuilding, Integer a_name, Integer pageIndex, Integer pageSize, Model model){
        PageInfo<Dormitory> dormitory = dormitoryService.findDormitory(s_dormitoryid, d_dormbuilding, a_name, pageIndex, pageSize);
        model.addAttribute("di",dormitory);
        model.addAttribute("s_dormitoryid",s_dormitoryid);
        model.addAttribute("d_dormbuilding",d_dormbuilding);
        model.addAttribute("a_name",a_name);
        return "Dormitory/dormitory_list";
    }

   @RequestMapping("/addDormitory")
    public String addDormitory(@RequestBody()Dormitory dormitory){
       Integer integer = dormitoryService.addDormitory(dormitory);
       return "redirect:/findDormitory";
   }


    @RequestMapping("/findDormitoryById")
    public String findDormitoryById(Integer d_id, HttpSession session){
        Dormitory dormitorybyid = dormitoryService.findDormitorybyid(d_id);
         session.setAttribute("d",dormitorybyid);
    return "Dormitory/dormitory_edit";
    }

    @RequestMapping("/updateDormitory")
    public String updateDormitory(Dormitory dormitory){
        int i= dormitoryService.updateDormitory(dormitory);
        return "redirect:/findDormitory";
    }

    @RequestMapping("/deleteDormitory")
    public String deleteDormitory(Integer d_id){
        int i = dormitoryService.deleteDormitorybyid(d_id);
        return "redirect:/findDormitory";
    }

    //导出
   @ResponseBody
    @RequestMapping("/exportdormitorylist")
    public List<Dormitory> exportdormitorylist(){
        List<Dormitory> all = dormitoryService.getAll();
        return all;
    }

//人员信息
    @RequestMapping("/findDormitoryStudent")
    public String findDormitoryStudent(Integer s_dormitoryid,Model model){
        List<Dormitory> dormitoryStudent = dormitoryService.findDormitoryStudent(s_dormitoryid);
        model.addAttribute("ds",dormitoryStudent);
        return "Dormitory/dormitory_Studentlist";
    }


}
