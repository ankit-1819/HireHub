package com.hirehub.hirehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirehub.hirehub.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {
	
	List<JobApplication> findByUserId(long userId);

	List<JobApplication> findByJobId(long jobId);
	
	Boolean existsByUserIdAndJobId(long userId,long jobId);
	
	/*
	 * SELECT COUNT(*) > 0 FROM job_application WHERE user_id = ? AND job_id = ?
	 */
}
