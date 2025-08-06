package com.example.demo.controller.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Batch;

@Service
public interface BatchService {

	public void addBatch(Batch batch);

}
