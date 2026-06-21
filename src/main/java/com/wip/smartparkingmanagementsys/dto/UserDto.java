package com.wip.smartparkingmanagementsys.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {
	

	private Long user_id; //PK
	@NotBlank(message = "User name cannot be empty")
	@Size(min = 2, max = 30, message = "Name Must contain 3 to 30 character")
	private String username;
	@NotBlank(message = "User Email cannot be empty")
	@Email(message = "Invalid Email format")
	private String email;
	@NotBlank(message = "Password is Required")
	@Size(min = 6, max = 30, message = "Password Must contain 6 to 30 character")
	private String password;
	@NotBlank(message = "Password is Required")
	@Pattern(regexp = "ADMIN|USER", message = "Role must be Admin or User")
	private String role;
	private String token;
	


	//	public UserDto(Long user_id, String username, String email, String password, String role) {
//		super();
//		this.user_id = user_id;
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.role = role;
//	}
//	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(String token) {
		super();
		this.token = token;
	}

	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", role=" + role + "]";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
