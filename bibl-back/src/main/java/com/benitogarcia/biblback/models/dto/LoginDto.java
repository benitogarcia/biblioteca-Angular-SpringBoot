package com.benitogarcia.biblback.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginDto {

	@Email
	@NotBlank
	@NotEmpty
	@NotNull
	private String email;

	@NotBlank
	@NotEmpty
	@NotNull
	private String password;

	public LoginDto() {
	}

	public LoginDto(String email, String password) {
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "LoginDto [Enmail=" + email + ", password=" + password + "]";
	}

}
