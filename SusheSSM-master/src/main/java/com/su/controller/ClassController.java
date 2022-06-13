package com.su.controller;

import com.su.pojo.Admin;
import com.su.pojo.Class;
import com.su.pojo.PageInfo;
import com.su.pojo.Student;
import com.su.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping("/findClass")
    public String findClass(Integer c_classid, String c_classname, String c_counsellor,
                            Integer pageIndex, Integer pageSize, Model model){
        PageInfo<Class> pi = classService.findgetClass(c_classid, c_classname, c_counsellor, pageIndex, pageSize);
        model.addAttribute("ci",pi);
        model.addAttribute("c_classid",c_classid);
        model.addAttribute("c_classname",c_classname);
        model.addAttribute("c_counselloraaaaaa",c_counsellor);

        return "class/class_list";
    }

    @RequestMapping("/addClass")
    public String addClass(@RequestBody Class uclass){
        int i = classService.addClass(uclass);
        return "redirect:/findClass";
    }

    @RequestMapping("/findClassById")
    public String findClassById(Integer c_id, HttpSession session){
        Class classbyid = classService.findClassbyid(c_id);
        session.setAttribute("c",classbyid);
        return "class/class_edit";
    }

    @RequestMapping("/updateClass")
    public String updateClass(Class uclass){
       int i = classService.updateClass(uclass);
        return "redirect:/findClass";
    }



    @RequestMapping("/deleteClass")
    public String deleteClass(Integer c_id){
        int i = classService.deleteClassbyid(c_id);
        return "redirect:/findClass";
    }


    //导出
    @RequestMapping("/exportclasslist")
    @ResponseBody
    public List<Class> exportclasslist(){
        List<Class> all = classService.getAll();
        return all;
    }

    //班级学生信息
    @RequestMapping("/findClassStudent")
    public String findClassStudent(Integer c_classid,
                                   String c_classname,Model model){
        List<Class> classStudent = classService.findClassStudent(c_classid,c_classname);
        model.addAttribute("cs",classStudent);
        return "class/class_Studentlist";
    }

}
