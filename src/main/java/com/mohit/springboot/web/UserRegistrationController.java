package com.mohit.springboot.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mohit.springboot.model.User;
import com.mohit.springboot.service.UserService;
import com.mohit.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){  	
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if(userDto.getPassword().equals(userDto.getEmail())) {
            result.rejectValue("password", null, "Invalid Password Same As Username");
        }
        if (result.hasFieldErrors("password") || result.hasFieldErrors("email")){
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }
	
}
