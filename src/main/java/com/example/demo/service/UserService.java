package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.dao.getLoginDetails;
import com.example.demo.pojo.LoginDetails;

public class UserService implements UserDetailsService {
	
	private UserDetails ud; 

	@Autowired
	private getLoginDetails loginDetails;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<LoginDetails> data = loginDetails.findByUsername(username);
		
		this.ud = data.map(UserInfoService::new).orElseThrow(()-> new UsernameNotFoundException("Usrname not vaild"));
		return data.map(UserInfoService::new).orElseThrow(()-> new UsernameNotFoundException("Usrname not vaild"));
	}
	
	public UserDetails getUD() {
		return ud;
	}

}
