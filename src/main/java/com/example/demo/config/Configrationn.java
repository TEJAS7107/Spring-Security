package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.UserService;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class Configrationn {
	
	@Bean
	public  UserDetailsService userDetails(PasswordEncoder en) {
//				UserDetails u1 = User.withUsername("Admin").password(en.encode("1233")).roles("ADMIN").build();
//				
//				UserDetails u2 = User.withUsername("User").password(en.encode("2344")).roles("USER").build();
//				
//		InMemoryUserDetailsManager data = new InMemoryUserDetailsManager(u1,u2);
				
		
	return new UserService();
		
	}
	
	@SuppressWarnings("removal")
	@Bean
	public  SecurityFilterChain secure(HttpSecurity http) throws Exception {
		return http.csrf().disable().cors().disable().authorizeHttpRequests((authorize) -> authorize.requestMatchers("api/Welcome","api/new").permitAll()
				.requestMatchers("api/**").authenticated()
				
				
				).formLogin().and()
				.build();
//				.and().authorizeHttpRequests().requestMatchers("api/register").authenticated().and().formLogin().and().build();
		
//		return http
//	    .authorizeHttpRequests((authorize) -> authorize
//	        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
//	        .requestMatchers("/endpoint").permitAll()
//	        .anyRequest().denyAll()
//	        .bu
//	        
	       
	}
	
	@Bean
	public  PasswordEncoder passEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
}
