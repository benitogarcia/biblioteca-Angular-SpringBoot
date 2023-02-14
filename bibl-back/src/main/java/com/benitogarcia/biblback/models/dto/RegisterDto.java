package com.benitogarcia.biblback.models.dto;

public class RegisterDto {

	private String nombres;
	private String apellidos;
	private String username;
	private String email;
	private String password;

	public RegisterDto() {
	}

	public RegisterDto(String nombres, String apellidos, String username, String email, String password) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "RegisterDto [nombres=" + nombres + ", apellidos=" + apellidos + ", username=" + username + ", email="
				+ email + ", password=" + password + "]";
	}

}
