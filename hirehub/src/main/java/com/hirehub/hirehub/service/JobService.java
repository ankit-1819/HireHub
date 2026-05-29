package com.hirehub.hirehub.service;

import java.util.List;
import java.util.Optional;

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
	
	public Job getJobById(long id) {
		
		Optional<Job> getJob = jobRepository.findById(id);
		
		if(getJob.isEmpty()) {
			throw new IllegalArgumentException("Invalid Job Id");
		}
		
		return getJob.get();
	}
	
	public Job updateJob(long id ,Job job) {
		
		Job updatedJob = getJobById(id);
		
		updatedJob.setCompanyName(job.getCompanyName());
		updatedJob.setDescription(job.getDescription());
		updatedJob.setJobType(job.getJobType());
		updatedJob.setLocation(job.getLocation());
		updatedJob.setRequiredSkills(job.getRequiredSkills());
		updatedJob.setSalary(job.getSalary());
		updatedJob.setTitle(job.getTitle());
		
		return jobRepository.save(updatedJob);
	}
	
	public void deleteJob(long id) {
		
		getJobById(id);
		jobRepository.deleteById(id);
	}
}
