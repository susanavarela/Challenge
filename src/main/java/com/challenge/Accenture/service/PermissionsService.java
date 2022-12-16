package com.challenge.Accenture.service;

import java.util.List;

import com.challenge.Accenture.dto.PermissionDto;
import com.challenge.Accenture.dto.UserDto;
import com.challenge.Accenture.entities.Permission;

public interface PermissionsService {

	public boolean insert(PermissionDto permissionDto, int userId) throws Exception;
	
	public boolean update(PermissionDto permission, int userId)throws Exception;
	
	public List<UserDto> getUsersByAlbumAndPermission(int idAlbum, int permissionType)throws Exception;
	
	public Permission getPermissionByAlbumAndUser(int idAlbum, int idUser);
	
	public int getPermissionTypeByAlbumAndUser(int idAlbum, int idUser);
	
}
