package com.hirehub.hirehub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirehub.hirehub.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	public boolean existsByEmail(String email);
	
	public Optional<User> findByEmail(String email);
}
