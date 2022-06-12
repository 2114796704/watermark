package com.su.controller;

import com.su.pojo.PageInfo;
import com.su.pojo.StudentClean;
import com.su.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentCleancontroller {
      @Autowired
    StudentCleanService studentCleanService;

    @RequestMapping("/findStudentClean")
    public String findStudentClean(Integer s_studentid, String s_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize, Model model){
        PageInfo<StudentClean> studentClean = studentCleanService.getStudentClean(s_studentid, s_name, s_dormitoryid, pageIndex, pageSize);
        model.addAttribute("di",studentClean);
        model.addAttribute("s_studentid",s_studentid);
        model.addAttribute("s_name",s_name);
        model.addAttribute("s_dormitoryid",s_dormitoryid);
        return "DormClean/studentclean_list";
    }

    @RequestMapping("/addStudentClean")
    public String addStudentClean(@RequestBody()StudentClean studentClean){
        int i = studentCleanService.addStudentClean(studentClean);
        return "redirect:/findStudentClean";
    }
    @RequestMapping("/findStudentCleanById")
    public String findStudentCleanById(Integer g_id, HttpSession session){
        StudentClean studentCleanbyid = studentCleanService.findStudentCleanbyid(g_id);
        session.setAttribute("d",studentCleanbyid);
        return "DormClean/studentclean_edit";
    }
    @RequestMapping("/updateStudentClean")
    public String updateStudentClean(StudentClean studentClean){
        int i = studentCleanService.updateStudentClean(studentClean);
        return "redirect:/findStudentClean";
    }

    @RequestMapping("/deleteStudentClean")
    public String deleteStudentClean(Integer g_id){
        int i = studentCleanService.deleteStudentCleanbyid(g_id);
        return "redirect:/findStudentClean";
    }

    @RequestMapping("/exportstudentcleanlist")
    @ResponseBody
    public  List<StudentClean> exportstudentcleanlist(){
        List<StudentClean> all = studentCleanService.getAll();
        return all;
    }



}
