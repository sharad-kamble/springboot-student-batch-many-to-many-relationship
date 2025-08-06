package com.example.demo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Batch;
import com.example.demo.entity.Student;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    BatchRepository batchRepo;

    @Autowired
    StudentRepository studentRepo;

    @Override
    @Transactional
    public void enroll(int batchId, int sId) {
        Batch batch = batchRepo.findById(batchId).get();
        Student student = studentRepo.findById(sId).get();

        // update owning side
        student.getBatches().add(batch);

        // keep inverse side consistent in memory (optional)
        batch.getStudents().add(student);

        // save owning side so Hibernate inserts into join table
        studentRepo.save(student);
    }
}
