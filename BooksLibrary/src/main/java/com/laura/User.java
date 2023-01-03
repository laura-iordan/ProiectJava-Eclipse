package com.laura;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	private long userId;
	private String username;
	private String password;
	private int role;
	
	public User() {
		this.username = null;
		this.password = null;
		this.role = 0;
	}
	
	public User(long userId, String username, String password, int role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	
}
