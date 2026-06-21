package com.wip.smartparkingmanagementsys.service;

import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wip.smartparkingmanagementsys.entity.User;
import com.wip.smartparkingmanagementsys.repository.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userrepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		 User user =userrepository.findByEmail(email)
				 .orElseThrow(() -> new UsernameNotFoundException("OOPS!!! User Not Found...."));
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				Collections.emptyList()				
				);
	}

}