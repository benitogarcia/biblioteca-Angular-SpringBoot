package com.benitogarcia.biblback.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "libros")
public class LibroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Nombre es invalido.")
	@NotEmpty(message = "Nombre es invalido.")
	@NotNull(message = "Nombre es invalido.")
	private String nombre;

	@NotBlank(message = "Autor es invalido.")
	@NotEmpty(message = "Autor es invalido.")
	@NotNull(message = "Autor es invalido.")
	private String autor;

	@NotBlank(message = "Editorial es invalido.")
	@NotEmpty(message = "Editorial es invalido.")
	@NotNull(message = "Editorial es invalido.")
	private String editorial;

	@NotBlank(message = "Genero es invalido.")
	@NotEmpty(message = "Genero es invalido.")
	@NotNull(message = "Genero es invalido.")
	private String genero;

	@NotBlank(message = "País del autor es invalido.")
	@NotEmpty(message = "País del autor es invalido.")
	@NotNull(message = "País del autor es invalido.")
	private String pais_autor;

	@NotBlank(message = "Número de páginas es invalido.")
	@NotEmpty(message = "Número de páginas es invalido.")
	@NotNull(message = "Número de páginas es invalido.")
	private String num_pagina;

	@NotBlank(message = "Año de edición es invalido.")
	@NotEmpty(message = "Año de edición es invalido.")
	@NotNull(message = "Año de edición es invalido.")
	private String anio_edicion;

	@NotBlank(message = "Precio es invalido.")
	@NotEmpty(message = "Precio es invalido.")
	@NotNull(message = "Precio es invalido.")
	private String precio;

	public LibroEntity(Integer id, String nombre, String autor, String editorial, String genero, String pais_autor,
			String num_pagina, String anio_edicion, String precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.editorial = editorial;
		this.genero = genero;
		this.pais_autor = pais_autor;
		this.num_pagina = num_pagina;
		this.anio_edicion = anio_edicion;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPais_autor() {
		return pais_autor;
	}

	public void setPais_autor(String pais_autor) {
		this.pais_autor = pais_autor;
	}

	public String getNum_pagina() {
		return num_pagina;
	}

	public void setNum_pagina(String num_pagina) {
		this.num_pagina = num_pagina;
	}

	public String getAnio_edicion() {
		return anio_edicion;
	}

	public void setAnio_edicion(String anio_edicion) {
		this.anio_edicion = anio_edicion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "LibroEntity [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial
				+ ", genero=" + genero + ", pais_autor=" + pais_autor + ", num_pagina=" + num_pagina + ", anio_edicion="
				+ anio_edicion + ", precio=" + precio + "]";
	}

}
