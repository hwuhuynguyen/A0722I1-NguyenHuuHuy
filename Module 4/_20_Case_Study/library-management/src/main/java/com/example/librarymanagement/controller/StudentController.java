package com.example.librarymanagement.controller;

import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/list")
    public String displayStudentList(Model model) {
        List<Student> studentList = (List<Student>) studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "/student/list";
    }
}
