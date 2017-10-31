package com.online.market.user.model;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationForm {

	public static final String FIELD_NAME_EMAIL = "email";


	@Email
	@NotEmpty
	@Size(max = 100)
	private String email;
	
	
	@NotEmpty(message="Mobile cannot be empty")
	@Size(max=10,min=10,message="Please enter a valid mobile number")

	private String mobile;

	/*@NotEmpty
    @Size(max = 100)*/
	private String firstName;

	/* @NotEmpty
    @Size(max = 100)*/
	private String lastName;

	@NotEmpty(message="Password cannot be empty")
	private String password;

	private String passwordVerification;

	public RegistrationForm() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordVerification() {
		return passwordVerification;
	}

	public void setPasswordVerification(String passwordVerification) {
		this.passwordVerification = passwordVerification;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("email", email)
				.append("firstName", firstName)
				.append("lastName", lastName)
				.toString();
	}
}
