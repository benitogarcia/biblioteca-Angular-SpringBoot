package com.benitogarcia.biblback.service;

import java.util.List;

import com.benitogarcia.biblback.models.entity.LibroEntity;

public interface LibroService {
	
	LibroEntity save(LibroEntity libro);
	
	List<LibroEntity> findAll();
	
	LibroEntity findById(Integer id);	
	
	LibroEntity findByPais_autor(String pais_autor);
	
	List<LibroEntity> findByNombreContaining(String field);

	List<LibroEntity> findByAutorContaining(String field);

	List<LibroEntity> findByGeneroContaining(String field);

}
