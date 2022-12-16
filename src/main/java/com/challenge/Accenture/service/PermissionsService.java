package com.challenge.Accenture.service;

import java.util.List;

import com.challenge.Accenture.dto.PermissionDto;
import com.challenge.Accenture.dto.UserDto;

public interface PermissionsService {

	public boolean insert(PermissionDto permissionDto, int userId) throws Exception;
	
	public boolean update(PermissionDto permission, int userId)throws Exception;

	public List<PermissionDto> getPermissions(int idAlbum);
	
	public boolean delete(int id)throws Exception;
	
	public List<UserDto> getUsersByAlbumAndPermission(int idAlbum, int permissionType)throws Exception;
	

}
