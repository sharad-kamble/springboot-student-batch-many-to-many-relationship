package com.example.demo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Batch;
import com.example.demo.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	BatchRepository batchRepo;

	@Override
	public void addBatch(Batch batch) {

		batchRepo.save(batch);

	}

}
