package com.challenge.Accenture.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.Accenture.dto.AlbumDto;
import com.challenge.Accenture.dto.PermissionDto;
import com.challenge.Accenture.dto.UserDto;
import com.challenge.Accenture.entities.Permission;
import com.challenge.Accenture.repositories.PermissionRepository;
import com.challenge.Accenture.service.AlbumsService;
import com.challenge.Accenture.service.PermissionsService;
import com.challenge.Accenture.service.UsersService;

@Service("PermissionsServiceImpl")
public class PermissionsServiceImpl implements PermissionsService{

	@Autowired
	private UsersService usersService ;
	
	@Autowired
	private AlbumsService albumsService ;
	
	@Autowired
	private PermissionRepository permissionRepository ;
	
	//actualiza el permiso
	@Override
	public boolean update(PermissionDto permissionDto, int userId) throws Exception {
		AlbumDto album = albumsService.findById(permissionDto.getAlbum());
		if(album == null)throw new Exception("El album no fue encontrado");
		if(album.getUserId() != userId)throw new Exception("El permiso solo puede modificarlo el propietario del album");
		Permission permission = getPermissionByAlbumAndUser(permissionDto.getAlbum(), permissionDto.getUser());
		if(permission == null)  throw new Exception("El permiso no fue encontrado");
		if( permissionDto.getPermissionType() != 0 && permissionDto.getPermissionType() != 1 && permissionDto.getPermissionType() != 2)  throw new Exception("El tipo de permiso no es correcto");
		permission.setPermissionType(permissionDto.getPermissionType());
		permissionRepository.save(permission);
		return true;
	}
		
	//obtiene un permiso en base a un id
	public Permission getPermissionById(int idPermission){
		return permissionRepository.findById(idPermission).get();
	}
	
	//obtiene un permiso en base a un id de album y un id de usuario
	public Permission getPermissionByAlbumAndUser(int idAlbum, int idUser){
			return permissionRepository.findPermission(idAlbum, idUser);
		}
	
	
	//obtiene una lista de permisos en base a un id de album
	@Override
	public List<PermissionDto> getPermissions(int idAlbum) {
		List<Permission> Permissions = permissionRepository.findPermissionByAlbum(idAlbum);
		
		return  Permissions.stream().map(permission -> passagePermissionToPermissionDto(permission)).collect(Collectors.toList());
	}
	
	//pasa el permiso de entidad a permiso dto
	public PermissionDto passagePermissionToPermissionDto(Permission permission) {
		PermissionDto dto = new PermissionDto(permission.getUser(), permission.getAlbum(), permission.getPermissionType());
		return dto;
	}

	//elimina haciendo un borrado logico en base al id del permiso
	@Override
	public boolean delete(int id) throws Exception {
		Optional<Permission> permission = permissionRepository.findById(id);
		if(!permission.isPresent())throw new Exception("El permiso no fue encontrado");
		permission.get().setEnable(false);
		permissionRepository.save(permission.get());
		return false;
	}


	//inserta en la base de datos un permiso
	@Override
	public boolean insert(PermissionDto permissionDto, int userId) throws Exception {
		
		AlbumDto album = albumsService.findById(permissionDto.getAlbum());
		if(album.getTitle() == null)throw new Exception("El album no fue encontrado");
		
		if(album.getUserId() != userId)throw new Exception("El permiso solo puede modificarlo el propietario del album");
		
		UserDto User = usersService.findById(permissionDto.getUser());
		if(User.getName() == null)throw new Exception("El usuario no fue encontrado");
		
		if( permissionDto.getPermissionType() != 0 && permissionDto.getPermissionType() != 1 && permissionDto.getPermissionType() != 2)  throw new Exception("El tipo de permiso no es correcto");
		
		Permission permission = new Permission(permissionDto.getAlbum(), permissionDto.getUser(), permissionDto.getPermissionType());
		permission.setEnable(true);
		permissionRepository.save(permission);
		return true;
	}

	//obtiene una lista de usuarios en base a un id de album, tipo de permiso
	public List<UserDto> getUsersByAlbumAndPermission(int idAlbum, int permissionType)throws Exception{
		List<Permission> permissions = permissionRepository.getUsersByAlbumAndPermission(idAlbum, permissionType);
		if(permissions.isEmpty())throw new Exception("No se encuentran los usuarios con los permisos para ese album");
		List<UserDto> users = new ArrayList<UserDto>();
		for(Permission permission : permissions) {
			UserDto User = usersService.findById(permission.getUser());
			if(User.getName() == null)throw new Exception("El usuario no fue encontrado");
			users.add(User);
		}
		
		return users;
	}
}
