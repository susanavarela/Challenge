package com.challenge.Accenture.service;

import java.util.List;

import com.challenge.Accenture.dto.UserDto;

public interface UsersService {

	public List<UserDto> getUsers() ;
	
	public UserDto findById(int userId);
}
