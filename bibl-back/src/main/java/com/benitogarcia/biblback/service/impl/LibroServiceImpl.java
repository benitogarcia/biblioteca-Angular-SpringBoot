package com.benitogarcia.biblback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benitogarcia.biblback.models.entity.LibroEntity;
import com.benitogarcia.biblback.repository.LibroRepository;
import com.benitogarcia.biblback.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;

	@Override
	public LibroEntity save(LibroEntity libro) {
		return libroRepository.save(libro);
	}

	@Override
	public List<LibroEntity> findAll() {
		return libroRepository.findAll();
	}

	@Override
	public LibroEntity findById(Integer id) {
		return libroRepository.findById(id).orElse(null);
	}

	@Override
	public LibroEntity findByPais_autor(String pais_autor) {
		return libroRepository.findByPaisAutor(pais_autor);
	}

	@Override
	public List<LibroEntity> findByNombreContaining(String field) {
		return libroRepository.findByNombreContaining(field);
	}

	@Override
	public List<LibroEntity> findByAutorContaining(String field) {
		return libroRepository.findByAutorContaining(field);
	}

	@Override
	public List<LibroEntity> findByGeneroContaining(String field) {
		return libroRepository.findByGeneroContaining(field);
	}

}
