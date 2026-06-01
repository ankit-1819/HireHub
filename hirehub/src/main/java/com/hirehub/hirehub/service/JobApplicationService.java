package com.hirehub.hirehub.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirehub.hirehub.dto.ApplicationStatusDto;
import com.hirehub.hirehub.dto.ApplyJobDto;
import com.hirehub.hirehub.entity.Job;
import com.hirehub.hirehub.entity.JobApplication;
import com.hirehub.hirehub.entity.User;
import com.hirehub.hirehub.enums.ApplicationStatus;
import com.hirehub.hirehub.repository.JobApplicationRepository;

@Service
public class JobApplicationService {
	
	@Autowired
	JobApplicationRepository jobApplicationRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	JobService jobService;
	
	public JobApplication applyJob(ApplyJobDto dto) {
		
		
		if(jobApplicationRepository.existsByUserIdAndJobId(dto.getUserId(), dto.getJobId())) {
			
			throw new IllegalArgumentException("You have already applied for this job");
		}
		
		User user = userService.getUser(dto.getUserId());
		
		Job job = jobService.getJobById(dto.getJobId());
		
		JobApplication jobApplication = new JobApplication();
	
		jobApplication.setJob(job);
		jobApplication.setUser(user);
		jobApplication.setApplicationDate(LocalDate.now());
		jobApplication.setStatus(ApplicationStatus.APPLIED);
		
		return jobApplicationRepository.save(jobApplication);
	
	}
	
	public List<JobApplication> getApplicationByUser(long userId) {
		
		userService.getUser(userId);
		return jobApplicationRepository.findByUserId(userId);
		
	}

	public List<JobApplication> getApplicationByJob(long jobId) {
		jobService.getJobById(jobId);
		return jobApplicationRepository.findByJobId(jobId);
	}
	public JobApplication getApplicationById(long id) {
		Optional<JobApplication> application = jobApplicationRepository.findById(id);
		if(application.isEmpty()) {
			throw new IllegalArgumentException("Invalid Application Id");
		}
		
		return application.get();
	}
	
	public JobApplication updateStatus(long applicationId,ApplicationStatusDto dto) {
		JobApplication application = getApplicationById(applicationId);
		application.setStatus(dto.getStatus());
		return jobApplicationRepository.save(application);
	}
}
