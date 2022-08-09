package com.db.grad.javaapi.controller;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.repository.UserRepository;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.dto.SignUpRequest;

@RestController
@RequestMapping("/api/v1/user")
public class AuthController {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@Valid @RequestBody SignUpRequest signupRequest) throws NoSuchAlgorithmException {
		String encodedPassword = encoder.encode(signupRequest.getPass());
		
		if(encodedPassword.isEmpty())
			return new ResponseEntity<>("Error Creating user, invalid password", HttpStatus.NOT_ACCEPTABLE);
		
		if(userRepository.existsByEmail(signupRequest.getEmail()))
			return new ResponseEntity<>("User already exists", HttpStatus.ALREADY_REPORTED);

			userRepository.save(
					new User(
							signupRequest.getName(),
							signupRequest.getEmail(),
							encodedPassword,
							signupRequest.getRole()
					)
			);

		return new ResponseEntity<>("New user added", HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> loginUser() {
		return new ResponseEntity<>("Login Successful", HttpStatus.OK);
	}
}
