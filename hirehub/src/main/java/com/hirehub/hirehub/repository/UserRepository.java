package com.hirehub.hirehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirehub.hirehub.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
