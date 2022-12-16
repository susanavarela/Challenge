package com.challenge.Accenture.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.Accenture.dto.UserDto;
import com.challenge.Accenture.service.JsonPlaceHolderService;
import com.challenge.Accenture.service.UsersService;


@Service("UsersServiceImpl")
public class UsersServiceImpl implements UsersService{
	 
	@Autowired
	private JsonPlaceHolderService jsonPlaceHolderService ;

	//Obtiene todos los usuarios sin filtros
	@Override
	public List<UserDto> getUsers() {
		return jsonPlaceHolderService.getUsers();
	}

	//Obtiene un usuario por id
	@Override
	public UserDto findById(int userId){
		return jsonPlaceHolderService.getUserId(userId);
	}
		
         
		
}
