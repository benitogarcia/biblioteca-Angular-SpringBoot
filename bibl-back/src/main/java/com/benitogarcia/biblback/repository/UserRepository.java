package com.benitogarcia.biblback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benitogarcia.biblback.models.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	boolean existsByUsername(String field);

	boolean existsByEmail(String field);

	User findByEmail(String email);
}
