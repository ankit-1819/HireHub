package com.hirehub.hirehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hirehub.hirehub.dto.ApplicationStatusDto;
import com.hirehub.hirehub.dto.ApplyJobDto;
import com.hirehub.hirehub.entity.JobApplication;
import com.hirehub.hirehub.service.JobApplicationService;

@RestController
@RequestMapping("/hirehub/jobAppn")
public class JobApplicationController {

	@Autowired
	JobApplicationService jobApplicationService;
	
	
	@PostMapping("/apply")
	public ResponseEntity<JobApplication> applyJob(@RequestBody ApplyJobDto dto){
		
		
		return ResponseEntity.ok(jobApplicationService.applyJob(dto));
		
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<JobApplication>> jobDetailsByid(@PathVariable long userId){
		
		return ResponseEntity.ok(jobApplicationService.getApplicationByUser(userId));
	}
	
	@GetMapping("/job/{jobId}")
	public ResponseEntity<List<JobApplication>> userDetailsById(@PathVariable long jobId){
		
		return ResponseEntity.ok(jobApplicationService.getApplicationByJob(jobId));
	}
	
	@PutMapping("/status/{applicationId}")
	public ResponseEntity<JobApplication> updateApplicationStatus(@PathVariable long applicationId,@RequestBody ApplicationStatusDto dto){
		return ResponseEntity.ok(jobApplicationService.updateStatus(applicationId,dto));
	}
	
	@PutMapping("/withdraw/{applicationId}")
	public ResponseEntity<JobApplication> withdrawApplication(@PathVariable long applicationId,@RequestBody ApplicationStatusDto dto){
		return ResponseEntity.ok(jobApplicationService.updateStatus(applicationId,dto));
	}
} 

