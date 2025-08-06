package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.service.EnrollmentService;

@RestController
public class EnrollController {

	@Autowired
	EnrollmentService enrollmentService;

	@GetMapping("/enroll/{batch_id}/{student_id}")
	public String enollStudent(@PathVariable int batch_id, @PathVariable int student_id) {
		enrollmentService.enroll(batch_id, student_id);

		return "Student Enrolled";
	}

}
