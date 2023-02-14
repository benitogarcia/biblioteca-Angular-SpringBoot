package com.benitogarcia.biblback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benitogarcia.biblback.models.entity.User;
import com.benitogarcia.biblback.repository.UserRepository;
import com.benitogarcia.biblback.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean existsByUsername(String field) {
		return userRepository.existsByUsername(field);
	}

	@Override
	public boolean existsByEmail(String field) {
		return userRepository.existsByEmail(field);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
