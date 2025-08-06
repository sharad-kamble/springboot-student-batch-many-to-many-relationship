package com.example.demo.controller.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public interface StudentService {

	public void addStudent(Student student);

}
