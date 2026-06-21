package com.wip.smartparkingmanagementsys.service;

import com.wip.smartparkingmanagementsys.dto.UserDto;

public interface UserService {
	
	
	public void register(UserDto userdto);
	UserDto login(String email, String password);
}
