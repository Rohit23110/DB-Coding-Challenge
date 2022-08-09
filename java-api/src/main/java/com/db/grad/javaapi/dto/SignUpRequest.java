package com.db.grad.javaapi.dto;

public class SignUpRequest {

	private String name;
	private String email;
	private String pass;
	private String role;
	
	public SignUpRequest() {
		
	}
	
	public SignUpRequest(String name, String email, String pass, String role) {
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
