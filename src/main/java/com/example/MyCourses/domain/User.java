package com.example.MyCourses.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// id is generated automatically and can't be changed
	@Column(name = "id", nullable = false, updatable = false)
	private long id;

	// username is unique
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	// password can't be null
	@Column(name = "password", nullable = false)
	private String passwordHash;

	// email can't be null
	@Column(name = "email", nullable = false)
	private String email;

	// role can't be null
	@Column(name = "role", nullable = false)
	private String role;

	public User() {
	}

	public User(String username, String passwordHash, String email, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", email=" + email
				+ ", role=" + role + "]";
	}

}
