package com.mohit.springboot.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.mohit.springboot.model.User;
import com.mohit.springboot.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);

	User findByEmail(String email);
}
