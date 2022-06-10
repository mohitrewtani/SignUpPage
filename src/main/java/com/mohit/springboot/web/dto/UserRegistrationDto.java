package com.mohit.springboot.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserRegistrationDto {

	private String firstName;
	
	private String lastName;
	
	@NotEmpty
	@Email
	private String email;
	
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",
			    message = "Enter valid password Password Min: 1 lowercase and 1 uppercase alphabet • Min: 1 number • Min: 1 special character(@#$%)• 8-16 character length")
	@NotEmpty
	private String password;

	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",
			message = "Enter valid password Password Min: 1 lowercase and 1 uppercase alphabet • Min: 1 number • Min: 1 special character(@#$%)• 8-16 character length")
    @NotEmpty
    private String newPassword;
	
	public UserRegistrationDto(String firstname, String lastname, String email, String password) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public UserRegistrationDto() {

	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
