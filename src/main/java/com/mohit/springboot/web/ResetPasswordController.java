package com.mohit.springboot.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mohit.springboot.model.User;
import com.mohit.springboot.repository.UserRepository;
import com.mohit.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/resetpassword")
public class ResetPasswordController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	@GetMapping
	public String resetpassword() {
		return "resetpassword";
	}

	@ModelAttribute("resetPassword")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

    @PostMapping
    public String registerUserAccount(@ModelAttribute("resetPassword") @Valid UserRegistrationDto userDto,
                                      BindingResult result)
    {
    	User user = userRepository.findByEmail(userDto.getEmail());

    	if(user == null)result.rejectValue("email", null, "Invalid email");
    	if(!this.bCryptPasswordEncoder.matches(userDto.getPassword(), user.getPassword())) 
    		result.rejectValue("password", null, "Invalid Old Password");
    	if(userDto.getPassword().equals(userDto.getNewPassword()))
    		result.rejectValue("newPassword", null, "New Password same as Old Password");
    	if(result.hasErrors() && (result.hasFieldErrors("newPassword") ||
    			!result.hasFieldErrors("password") || !result.hasFieldErrors("email"))) {
    		System.out.println(result.getAllErrors());
    		return "/resetpassword";
    	}
		
    	user.setPassword(this.bCryptPasswordEncoder.encode(userDto.getNewPassword()));
        userRepository.save(user);

        System.out.println("password set succesfuly");
        return "redirect:/resetpassword?success";
    }



}
