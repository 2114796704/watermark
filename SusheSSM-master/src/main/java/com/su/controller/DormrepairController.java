package com.su.controller;

import com.su.pojo.DormRepair;
import com.su.pojo.PageInfo;
import com.su.service.DormitoryService;
import com.su.service.DormrepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DormrepairController {

    @Autowired
    DormrepairService dormrepairService;

    @RequestMapping("/findDormRepair")
    public String findDormRepair(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize, Model model){
        PageInfo<DormRepair> dormRepairPageInfo = dormrepairService.findgetDormrepair(d_id, d_dormbuilding, pageIndex, pageSize);
         model.addAttribute("di",dormRepairPageInfo);
         model.addAttribute("d_id",d_id);
        model.addAttribute("d_dormbuilding",d_dormbuilding);
        return "Dormrepair/dormrepair_list";
    }


    @RequestMapping("/addDormRepair")
    @ResponseBody
    public String addDormRepair(@RequestBody() DormRepair dormRepair){
        int i = dormrepairService.addDormRepair(dormRepair);
        //前端ajax刷新了
        return "ok";
    }

    @RequestMapping("/findDormRepairById")
    public String findDormRepairById(Integer r_id, HttpSession session){
        DormRepair dormRepairbyid = dormrepairService.findDormRepairbyid(r_id);
       session.setAttribute("d",dormRepairbyid);
        return "Dormrepair/dormrepair_edit";
    }


    @RequestMapping("/updateDormRepair")
    public String updateDormRepair(DormRepair dormRepair){
        int i = dormrepairService.updateDormRepair(dormRepair);
        return "redirect:/findDormRepair";
    }

    @RequestMapping("/deleteDormRepair")
    public String deleteDormRepair(Integer r_id){
        int i = dormrepairService.deleteDormRepair(r_id);
        return "redirect:/findDormRepair";
    }

    //导出
    @RequestMapping("/exportdormrepairlist")
    @ResponseBody
    public  List<DormRepair> deleteDormRepair(){
        List<DormRepair> all = dormrepairService.getAll();

        return  all;
    }

}
