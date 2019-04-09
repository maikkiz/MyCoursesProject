package com.example.MyCourses.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	// finds user by username
	User findByUsername(String username);

}
