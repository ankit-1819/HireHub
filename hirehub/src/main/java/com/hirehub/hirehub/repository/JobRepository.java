package com.hirehub.hirehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirehub.hirehub.entity.Job;

public interface JobRepository extends JpaRepository<Job,Long> {

}
