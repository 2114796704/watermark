package com.su.controller;

import com.su.pojo.Class;
import com.su.pojo.DormClean;
import com.su.pojo.PageInfo;
import com.su.service.DormCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DormCleanController {

    @Autowired
    DormCleanService dormCleanService;

    @RequestMapping("/findDormClean")
    public String findDormClean(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize,Model model){
        PageInfo<DormClean> dormCleanPageInfo = dormCleanService.findgetDormClean(d_id, d_dormbuilding, pageIndex, pageSize);
          model.addAttribute("di",dormCleanPageInfo);
        model.addAttribute("d_id",d_id);
        model.addAttribute("d_dormbuilding",d_dormbuilding);
        return "DormClean/dormclean_list";
    }

    @RequestMapping("/addDormClean")
    public String addDormClean(@RequestBody() DormClean dormClean){
        int i = dormCleanService.addDormClean(dormClean);
        return "DormClean/dormclean_list";
    }

    @RequestMapping("/findDormCleanById")
    public String findDormCleanById(Integer g_id, HttpSession session){
        DormClean dormCleanbyid = dormCleanService.findDormCleanbyid(g_id);
           session.setAttribute("d",dormCleanbyid);
        return "DormClean/dormclean_edit";
    }

    @RequestMapping("/updateDormClean")
    public String updateDormClean(DormClean dormClean){
        int i = dormCleanService.updateDormClean(dormClean);
        return "redirect:/findDormClean";
    }
    @RequestMapping("/deleteDormClean")
    public String deleteDormClean(Integer g_id){
        int i = dormCleanService.deleteDormClean(g_id);
        return "redirect:/findDormClean";
    }

    @RequestMapping("/exportdormcleanlist")
    @ResponseBody
    public  List<DormClean> exportdormcleanlist(){
        List<DormClean> all = dormCleanService.getAll();
        return all;
    }


}
