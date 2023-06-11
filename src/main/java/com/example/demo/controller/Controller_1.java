package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dao.getDetails;
import com.example.demo.dao.getLoginDetails;
import com.example.demo.pojo.Details;
import com.example.demo.pojo.LoginDetails;


@RestController
@RequestMapping("/api")
public class Controller_1 {
	
	@Autowired
	getDetails deatails;
	
	@Autowired
	getLoginDetails data1;
	
	@Autowired
	PasswordEncoder Encoder;
	
	@GetMapping("/Welcome")
	public String Welcome() {
		
		return "This is not a secured endpoint and is only for testing";
	}
	@GetMapping("/register")
	public String getData() {
		
		return "this is a secured endpoint";
	}
	
	@PostMapping("/new")
	public String addUser(@RequestBody LoginDetails ld) {
		
		ld.setPassword(Encoder.encode(ld.getPassword()));
		
		data1.save(ld);
		
		
		
		return "New User Created Successfully";
		
		
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/data")
	public List<Details> getdata() {
		List<Details> info = deatails.findAll();	
		return info;
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/{id}")
	public Optional<Details> getById(@PathVariable int id) {
		return deatails.findById(id);
	}
	
}
