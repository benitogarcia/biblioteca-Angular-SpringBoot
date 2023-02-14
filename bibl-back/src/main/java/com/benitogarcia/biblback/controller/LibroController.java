package com.benitogarcia.biblback.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitogarcia.biblback.service.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {

	@Autowired
	private LibroService libroService;

	@GetMapping()
	public ResponseEntity<?> save(@Valid @RequestBody Object body, BindingResult br) {
		return null;
	}

}
