package com.hirehub.hirehub.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class JobApplication {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private LocalDate applicationDate;
		private String status;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private Job job;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private User user;
		
		public JobApplication() {
			// TODO Auto-generated constructor stub
		}
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public LocalDate getApplicationDate() {
			return applicationDate;
		}

		public void setApplicationDate(LocalDate applicationDate) {
			this.applicationDate = applicationDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Job getJob() {
			return job;
		}

		public void setJob(Job job) {
			this.job = job;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
}
