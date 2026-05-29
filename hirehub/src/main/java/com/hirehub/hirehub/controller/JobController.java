package com.hirehub.hirehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable long id){
		
		return ResponseEntity.ok(jobService.getJobById(id)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable long id,@RequestBody Job job){
		
		return ResponseEntity.ok(jobService.updateJob(id,job));
	}
	
	@DeleteMapping("/{id}")
	public String deleteJob(@PathVariable long id) {
		
		jobService.deleteJob(id);
		return "Job Successfully Deleted";
	}
}
