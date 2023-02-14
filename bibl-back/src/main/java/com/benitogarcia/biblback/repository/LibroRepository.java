package com.benitogarcia.biblback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.benitogarcia.biblback.models.entity.LibroEntity;

public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {

	@Query("select l from LibroEntity l where l.pais_autor = ?1")
	LibroEntity findByPaisAutor(String pais_autor);

	List<LibroEntity> findByNombreContaining(String field);

	List<LibroEntity> findByAutorContaining(String field);

	List<LibroEntity> findByGeneroContaining(String field);
	

}
