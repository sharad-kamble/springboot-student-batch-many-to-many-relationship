package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.service.StudentService;
import com.example.demo.entity.Student;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentservice;

    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        studentservice.addStudent(student);
        return "student added";
    }
}
