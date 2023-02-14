package com.benitogarcia.biblback.service;

import com.benitogarcia.biblback.models.entity.User;

public interface UsuarioService {

	User findByUsername(String username);
	
	User save(User user);

	boolean existsByUsername(String field);

	boolean existsByEmail(String field);

	User findByEmail(String email);
}
