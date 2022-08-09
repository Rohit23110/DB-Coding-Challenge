package com.db.grad.javaapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.dto.LoginRequest;
import com.db.grad.javaapi.dto.SignupRequest;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/auth/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequest signupRequest) {
		
		if(signupRequest.getPassword().isEmpty())
			return new ResponseEntity<>("Error Creating user, invalid password", HttpStatus.NOT_ACCEPTABLE);
		
		if(userRepository.existsByEmail(signupRequest.getEmail()))
			return new ResponseEntity<>("User already exists", HttpStatus.ALREADY_REPORTED);

			userRepository.save(
					new User(
							signupRequest.getName(),
							signupRequest.getEmail(),
							signupRequest.getPassword(),
							signupRequest.getRole()					
					)
			);

		return new ResponseEntity<>("New user added", HttpStatus.OK);
    }
    
    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
    	
    	if(!userRepository.existsByEmail(loginRequest.getEmail()))
    		return new ResponseEntity<>("No such user exists", HttpStatus.NOT_FOUND);
    	
    	User user = userRepository.findByEmail(loginRequest.getEmail());
    	if(!user.getPassword().equals(loginRequest.getPassword()))
    		return new ResponseEntity<>("Wrong password", HttpStatus.BAD_REQUEST);
    	
    	return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }
}
