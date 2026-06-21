package com.wip.smartparkingmanagementsys.util;

import com.wip.smartparkingmanagementsys.dto.UserDto;
import com.wip.smartparkingmanagementsys.entity.User;



public class UserConverter {
	
	public static User toEntity(UserDto dto) {
		User User = new User();

		User.setUser_id(dto.getUser_id());
		User.setUsername(dto.getUsername());
		User.setEmail(dto.getEmail());
		User.setPassword(dto.getPassword());
		User.setRole(dto.getRole());
		return User;
	}
	
	public static UserDto toDto(User User) {
		UserDto userdto = new UserDto();
		userdto.setUser_id(User.getUser_id());
		userdto.setUsername(User.getUsername());
		userdto.setEmail(User.getEmail());
		userdto.setPassword(User.getPassword());
		userdto.setRole(User.getRole());
		return userdto;
	}

}
