package com.su.controller;

import com.su.pojo.PageInfo;
import com.su.pojo.Student;
import com.su.pojo.Visitor;
import com.su.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @RequestMapping("/findVisitor")
    public String findVisitor(String v_name, Long v_phone, Integer pageIndex, Integer pageSize , Model model){
        PageInfo<Visitor> visitor = visitorService.getVisitor(v_name, v_phone, pageIndex, pageSize);
        model.addAttribute("pi",visitor);
        model.addAttribute("v_name",v_name);
        model.addAttribute("v_phone",v_phone);
        return "Visitor/visitor_list";
    }


    @RequestMapping("/addVisitor")
    public String addVisitor(@RequestBody Visitor visitor){
        int i = visitorService.addVisitor(visitor);
        return "redirect:/findVisitor";
    }

    @RequestMapping("/exportvisitorlist")
    @ResponseBody
    public  List<Visitor> exportvisitorlist(){
        List<Visitor> all = visitorService.getAll();
        return all;
    }
}
