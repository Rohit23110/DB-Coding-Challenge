package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Boolean existsByEmail(String email);
	User findByEmail(String email);
	User saveUser(User user);
}