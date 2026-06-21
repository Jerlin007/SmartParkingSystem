package com.wip.smartparkingmanagementsys.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wip.smartparkingmanagementsys.dto.UserDto;
import com.wip.smartparkingmanagementsys.entity.User;
import com.wip.smartparkingmanagementsys.repository.UserRepository;
import com.wip.smartparkingmanagementsys.security.JwtUtil;
import com.wip.smartparkingmanagementsys.util.UserConverter;




@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	@Override
	public void register(UserDto userdto) {
		
		User User = UserConverter.toEntity(userdto);
		
		User.setPassword(passwordEncoder.encode(userdto.getPassword()));
		
		userrepository.save(User);
		System.out.println("User Created ...");
		
	}

	@Override
	public UserDto login(String email, String password) {
	    User user = userrepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));
	    if (!passwordEncoder.matches(password, user.getPassword()))
	        throw new RuntimeException("Invalid password");
	    String token = jwtUtil.generateToken(email);
	    UserDto response = new UserDto(token);
	    response.setRole(user.getRole());
	    return response;
	}
	
	

	


}
