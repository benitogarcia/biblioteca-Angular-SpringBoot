package com.benitogarcia.biblback.models.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	@NotBlank(message = "Username es inválido")
	@NotEmpty(message = "Username es inválido")
	@NotNull(message = "Username es inválido")
	private String username;

	@NotBlank(message = "Nombre es inválido")
	@NotEmpty(message = "Nombre es inválido")
	@NotNull(message = "Nombre es inválido")
	private String nombres;

	@NotBlank(message = "Apellidos es inválido")
	@NotEmpty(message = "Apellidos es inválido")
	@NotNull(message = "Apellidos es inválido")
	private String apellidos;

	@Column(unique = true)
	@Email(message = "Email es inválido")
	private String email;

	@NotBlank(message = "Contraseña es inválido")
	@NotEmpty(message = "Contraseña es inválido")
	@NotNull(message = "Contraseña es inválido")
	private String password;

	private String role;

	public User() {
	}

	public User(String username, String nombres, String apellidos, String email, String password, String role) {
		super();
		this.username = username;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + username + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}

}
