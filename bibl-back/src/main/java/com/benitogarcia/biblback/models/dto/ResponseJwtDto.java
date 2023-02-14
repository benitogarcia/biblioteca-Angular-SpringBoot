package com.benitogarcia.biblback.models.dto;

public class ResponseJwtDto {

	private String username;
	private String nombres;
	private String apellidos;
	private String token;
	private String role;

	public ResponseJwtDto() {
	}

	public ResponseJwtDto(String username, String nombres, String apellidos, String token, String role) {
		super();
		this.username = username;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.token = token;
		this.role = role;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
