package com.su.controller;

import com.su.pojo.PageInfo;
import com.su.pojo.Student;
import com.su.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
@RequestMapping("/findStudent")
    public String findStudent(String s_name, Integer s_studentid, Integer s_classid, String s_classname, Integer pageIndex, Integer pageSize, Model model){
    PageInfo<Student> studentPageInfo = studentService.findgetStudent(s_name, s_studentid, s_classid, s_classname, pageIndex, pageSize);
   model.addAttribute("pi",studentPageInfo);
    model.addAttribute("s_name",s_name);
    model.addAttribute("s_studentid",s_studentid);
    model.addAttribute("s_classid",s_classid);
    model.addAttribute("s_classname",s_classname);
    return "student/student_list";
 }

 //添加功能
    @RequestMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        int i = studentService.addStudent(student);
        return "redirect:/findStudent";
    }

/**
 *   修改功能
 *   1.查找要修改的学生，并显示在改页面
 *   2.修改
 * */
      @RequestMapping("/findStudentById")
    public String findStudentById(Integer s_id, HttpSession session){

          Student student = studentService.findStudentbyid(s_id);
           session.setAttribute("s",student);
          return "student/student_edit";
      }

      @RequestMapping("updateStudent")
      public String updateStudent(Student student){
          int i = studentService.updateStudent(student);
          return "redirect:/findStudent";
      }

       @RequestMapping("/deleteStudent")
    public String deleteStudent(@Param("s_id") Integer s_id){
           int i = studentService.deleteStudentbyid(s_id);
           return "redirect:/findStudent";
       }

}
