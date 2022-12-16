package com.challenge.Accenture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.Accenture.dto.AlbumDto;
import com.challenge.Accenture.dto.CommentNameDto;
import com.challenge.Accenture.dto.PermissionDto;
import com.challenge.Accenture.dto.PhotoDto;
import com.challenge.Accenture.dto.UserDto;
import com.challenge.Accenture.service.AlbumsService;
import com.challenge.Accenture.service.CommentsService;
import com.challenge.Accenture.service.PermissionsService;
import com.challenge.Accenture.service.PhotosService;
import com.challenge.Accenture.service.UsersService;



@RestController
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	private UsersService usersService ;
	
	@Autowired
	private AlbumsService albumsService ;
	
	@Autowired
	private PhotosService photosService ;
	
	@Autowired
	private PermissionsService permissionsService ;
	
	@Autowired
	private CommentsService commentsService ;
	
	//retorna todos los usuarios
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> findAllUsers(){
		return ResponseEntity.ok().body(usersService.getUsers());
	}
	
	//retorna todos los albunes
	@GetMapping("/albums")
	public ResponseEntity<List<AlbumDto>> findAllAlbums(){
		return ResponseEntity.ok().body(albumsService.getAlbums());
	}
	
	//retorna todos los fotos de un album
	@GetMapping("/photos/{idalbum}")
	public ResponseEntity<List<PhotoDto>> findAllPhotos(@PathVariable("idalbum") int idAlbum){
		return ResponseEntity.ok().body(photosService.getPhotos(idAlbum));
	}
	
	//retorna todas las fotos de un usuario
	@GetMapping("/photos/user={iduser}")
	public ResponseEntity<Object> findPhotosByUser(@PathVariable("iduser") int idUser){
		try {	
			return ResponseEntity.status(HttpStatus.CREATED).body(photosService.getPhotosByUser(idUser));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la busqueda de datos, " + e.getMessage());
		}
	}
	
	//retorna todos los albunes de un usuario enviando su id
	@GetMapping("/userandalbums/{id}")
	public ResponseEntity<List<AlbumDto>> userAndAlbums(@PathVariable("id") int id){
		return ResponseEntity.ok().body(albumsService.getUserAndAlbums(id));
	}
	
	/*************** Permisos ********************/
	
	//crea un permiso, solo el titular del album
	@PostMapping("/newpermission/{id}")
	public ResponseEntity<Object> newPermission (@RequestBody PermissionDto permissionDto, @PathVariable("id") int userId){	
		try {	
			permissionsService.insert(permissionDto, userId);
			return ResponseEntity.status(HttpStatus.CREATED).body("Permiso creado exitosamente");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el permiso, " + e.getMessage());
		}
	}
	
	//actualiza el tipo de permiso, solo el titular del album
	@PutMapping("/updatepermission/{id}")
	public ResponseEntity<Object> updatePermission (@RequestBody PermissionDto permissionDto, @PathVariable("id") int userId){	
		try {	
			permissionsService.update(permissionDto, userId);
			return ResponseEntity.status(HttpStatus.CREATED).body("Permiso ha sido actualizado correctamente");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar el permiso, " + e.getMessage());
		}
	}
	
	//retorna lista de usuarios de un album especifico y un tipo de permiso
	@GetMapping("/usersandpermissions/album={idalbum}/permission={idpermission}")
	public ResponseEntity<Object> getUsersByAlbumAndPermission (@PathVariable("idalbum") int idAlbum, @PathVariable("idpermission") int idPermission){	
		try {	
			return ResponseEntity.status(HttpStatus.CREATED).body(permissionsService.getUsersByAlbumAndPermission(idAlbum, idPermission));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la busqueda de datos, " + e.getMessage());
		}
	}
	
	//retorna lista de comentarios en base a postId
	@GetMapping("/comment/{id}")
	public ResponseEntity<Object> getcommentsByPostId(@PathVariable("id") int postId){	
		try {	
			return ResponseEntity.status(HttpStatus.CREATED).body(commentsService.getCommentsByPostId(postId));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la busqueda de datos, " + e.getMessage());
		}
	}
	
		
}
