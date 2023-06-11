package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.LoginDetails;

public interface getLoginDetails extends JpaRepository<LoginDetails, Integer>{

	Optional<LoginDetails> findByUsername(String username);
	
}
