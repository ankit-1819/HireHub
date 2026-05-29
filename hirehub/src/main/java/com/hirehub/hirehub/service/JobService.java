package com.hirehub.hirehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirehub.hirehub.entity.Job;
import com.hirehub.hirehub.repository.JobRepository;

@Service
public class JobService {
	
	@Autowired
	JobRepository jobRepository;
	
	public Job registerJob(Job job) {
		
		//if(!jobRepository.existsById(job.getId())) {
		//	throw new IllegalArgumentException("Job Alredy Register!!!");
		//}
		
		Job savedJob = jobRepository.save(job);
		return savedJob;
	}
	
	public List<Job> getAllJob(){
		
		return jobRepository.findAll();
	}
}
