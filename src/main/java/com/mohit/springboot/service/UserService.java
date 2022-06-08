package com.mohit.springboot.service;


import com.mohit.springboot.model.User;
import com.mohit.springboot.web.dto.UserRegistrationDto;


public interface UserService {

	User save(UserRegistrationDto registrationDto);
}
