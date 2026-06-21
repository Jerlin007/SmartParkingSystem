package com.wip.smartparkingmanagementsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wip.smartparkingmanagementsys.dto.UserDto;
import com.wip.smartparkingmanagementsys.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody UserDto userdto ){
		userservice.register(userdto);
		
		return new ResponseEntity<>("User " + userdto.getUsername() + " created Successfully",HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody UserDto dto) {
	    UserDto response = userservice.login(dto.getEmail(), dto.getPassword());
	    return ResponseEntity.ok(response); // returns full object with token AND role
	}

	
	
}
