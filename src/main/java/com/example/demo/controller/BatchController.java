package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.service.BatchService;
import com.example.demo.entity.Batch;

@RestController
public class BatchController {

    @Autowired
    private BatchService batchservice;

    @PostMapping("/batch")
    public String addBatch(@RequestBody Batch batch) {
        batchservice.addBatch(batch);          // ← CALL THE SERVICE
        return "batch added";
    }
}
