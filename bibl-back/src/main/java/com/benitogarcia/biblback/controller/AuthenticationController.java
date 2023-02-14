package com.benitogarcia.biblback.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitogarcia.biblback.models.dto.LoginDto;
import com.benitogarcia.biblback.models.dto.ResponseJwtDto;
import com.benitogarcia.biblback.models.dto.ResponseStatusDto;
import com.benitogarcia.biblback.models.entity.User;
import com.benitogarcia.biblback.service.JwtUserDetailsService;
import com.benitogarcia.biblback.service.UsuarioService;
import com.benitogarcia.biblback.util.JwtTokenUtil;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private UsuarioService usuarioService;
	// private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDto login, BindingResult br) {

		ResponseStatusDto rsdto = null;

		if (br.hasErrors()) {
			rsdto = new ResponseStatusDto(401, "Unauthorized", "Correo/Contraseña es invalido.", null);
			return ResponseEntity.status(401).body(rsdto);
		}

		try {

			User user = usuarioService.findByEmail(login.getEmail().toUpperCase());

			if (user == null) {
				rsdto = new ResponseStatusDto(401, "Unauthorized", "Correo/Contraseña es invalido.", null);
				return ResponseEntity.status(401).body(rsdto);
			}
			
			BCryptPasswordEncoder passwordEncoder  = new BCryptPasswordEncoder();
			
			String passDesce = login.getPassword();

			if (!passwordEncoder.matches(passDesce, user.getPassword())) {
				rsdto = new ResponseStatusDto(401, "Unauthorized", "Correo/Contraseña es invalido.", null);
				return ResponseEntity.status(401).body(rsdto);
			}

			UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
			String token = jwtTokenUtil.generateToken(userDetails);
			ResponseJwtDto jwt = new ResponseJwtDto(login.getEmail(), user.getNombres(), user.getApellidos(), token,
					user.getRole());
			return ResponseEntity.ok(jwt);

			/*
			 * User u2 = usuarioService.findByEmail(login.getEmail());
			 * 
			 * if (u2 == null) { rsdto = new ResponseStatusDto(401, "Unauthorized",
			 * "Correo/Contraseña es invalido.", null); return
			 * ResponseEntity.status(401).body(rsdto); }
			 * 
			 * Authentication auth = authenticationManager .authenticate(new
			 * UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
			 * 
			 * if (auth.isAuthenticated()) { logger.info("Logged In"); UserDetails
			 * userDetails = userDetailsService.loadUserByUsername(login.getEmail()); User u
			 * = usuarioService.findByUsername(login.getEmail()); String token =
			 * jwtTokenUtil.generateToken(userDetails); ResponseJwtDto jwt = new
			 * ResponseJwtDto(login.getEmail(), u.getNombres(), u.getApellidos(), token,
			 * u.getRole()); return ResponseEntity.ok(jwt); } else { rsdto = new
			 * ResponseStatusDto(401, "Unauthorized", "Username/Contraseña es invalido.",
			 * null); return ResponseEntity.status(401).body(rsdto); }
			 */

		} catch (DisabledException e) {
			rsdto = new ResponseStatusDto(401, "Unauthorized", "El usuario está deshabilitado.", null);
			return ResponseEntity.status(500).body(rsdto);
		} catch (BadCredentialsException e) {
			rsdto = new ResponseStatusDto(401, "Unauthorized", "Credenciales no válidas.", null);
			return ResponseEntity.status(401).body(rsdto);
		} catch (Exception e) {
			rsdto = new ResponseStatusDto(500, "Unauthorized", "Algo salió mal.", null);
			return ResponseEntity.status(500).body(rsdto);
		}
	}

	@PostMapping("/signin")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult br) {

		ResponseStatusDto rsdto = null;

		if (br.hasErrors()) {
			rsdto = new ResponseStatusDto(400, "Bad Request.", "Error el datos del formulario.", null);
			return ResponseEntity.badRequest().body(rsdto);
		}

		if (usuarioService.existsByEmail(user.getEmail())) {
			rsdto = new ResponseStatusDto(400, "Bad Request.", "Correo ya esta registrado.", null);
			return ResponseEntity.badRequest().body(rsdto);
		}

		if (usuarioService.existsByUsername(user.getUsername())) {
			rsdto = new ResponseStatusDto(400, "Bad Request.", "Username ya se encuentra registrado.", null);
			return ResponseEntity.badRequest().body(rsdto);
		}

		String role = (user.getRole() == null || user.getRole().isEmpty() || user.getRole().isBlank()) ? "USER"
				: user.getRole();
		user.setRole(role);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setEmail(user.getEmail().toUpperCase());

		user = usuarioService.save(user);
		
		

		if (user == null) {
			rsdto = new ResponseStatusDto(500, "Internal Server Error.", "El nombre de usuario debe ser único.", null);
			return ResponseEntity.badRequest().body(rsdto);
		}
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());		
		ResponseJwtDto jwt = new ResponseJwtDto(user.getUsername(), user.getNombres(), user.getApellidos(), null,
				user.getRole());
		
		String token = jwtTokenUtil.generateToken(userDetails);
		jwt.setToken(token);
		return ResponseEntity.ok(jwt);
		
	}

}
