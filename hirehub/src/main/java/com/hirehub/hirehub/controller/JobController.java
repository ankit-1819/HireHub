package com.hirehub.hirehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hirehub.hirehub.entity.Job;
import com.hirehub.hirehub.service.JobService;

@RestController
@RequestMapping("/hirehub/job")
public class JobController {

	@Autowired
	JobService jobService;
	
	@PostMapping("/add")
	public ResponseEntity<Job> registerJob(@RequestBody Job job){
		
		Job newJob = jobService.registerJob(job);
		
		return ResponseEntity.ok(newJob);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Job>> getAllJob(){
		
		List<Job> allJob = jobService.getAllJob();
		return ResponseEntity.ok(allJob);
		
	}
	
	
}
