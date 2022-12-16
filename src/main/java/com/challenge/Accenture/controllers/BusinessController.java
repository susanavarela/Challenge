package com.challenge.Accenture.controllers;

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
import com.challenge.Accenture.dto.CommentDto;
import com.challenge.Accenture.dto.PermissionDto;
import com.challenge.Accenture.dto.PhotoDto;
import com.challenge.Accenture.dto.UserDto;
import com.challenge.Accenture.service.AlbumsService;
import com.challenge.Accenture.service.CommentsService;
import com.challenge.Accenture.service.PermissionsService;
import com.challenge.Accenture.service.PhotosService;
import com.challenge.Accenture.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



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
	
	@Operation(summary = "Trae todos los usuarios")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Se trae a los usuarios con exito", 
	    content = { @Content(mediaType = "application/json", 
	    schema = @Schema(implementation = UserDto.class)) }),
	@ApiResponse(responseCode = "404", description = "Los usuarios no fueron encontrados en el servicio web", content = @Content)})
	@GetMapping("/users")
	public ResponseEntity<Object> findAllUsers(){
		try {
			return ResponseEntity.ok().body(usersService.getUsers());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@Operation(summary = "Trae todos los albums")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Se trae a los albums con exito", 
	    content = { @Content(mediaType = "application/json", 
	    schema = @Schema(implementation = AlbumDto.class)) }),
	@ApiResponse(responseCode = "404", description = "Los albums no fueron encontrados en el servicio web", content = @Content)})
	@GetMapping("/albums")
	public ResponseEntity<Object> findAllAlbums(){
		try {
			return ResponseEntity.ok().body(albumsService.getAlbums());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}	
	}
	
	@Operation(summary = "Trae todas las fotos de un album")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Se trae a las fotos con exito", 
	    content = { @Content(mediaType = "application/json", 
	    schema = @Schema(implementation = PhotoDto.class)) }),
	@ApiResponse(responseCode = "404", description = "Las fotos no fueron encontradas en el servicio web", content = @Content)})
	@GetMapping("/photos/{idalbum}")
	public ResponseEntity<Object> findAllPhotos(@PathVariable("idalbum") int idAlbum){
		try {
			return ResponseEntity.ok().body(photosService.getPhotos(idAlbum));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}		
	}
	
	@Operation(summary = "Trae todas las fotos de un usuario")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Se trae a las fotos con exito", 
	    content = { @Content(mediaType = "application/json", 
	    schema = @Schema(implementation = PhotoDto.class)) }),
	@ApiResponse(responseCode = "404", description = "Las fotos no fueron encontradas en el servicio web", content = @Content)})
	@GetMapping("/photos/user={iduser}")
	public ResponseEntity<Object> findPhotosByUser(@PathVariable("iduser") int idUser){
		try {	
			return ResponseEntity.ok().body(photosService.getPhotosByUser(idUser));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en la busqueda de datos, " + e.getMessage());
		}
	}
	
	@Operation(summary = "Trae todos los albums de un usuario enviando su id")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Se trae todos los albums con exito", 
	    content = { @Content(mediaType = "application/json", 
	    schema = @Schema(implementation = AlbumDto.class)) }),
	@ApiResponse(responseCode = "404", description = "Los albums no fueron encontradas en el servicio web", content = @Content)})
	@GetMapping("/userandalbums/{id}")
	public ResponseEntity<Object> userAndAlbums(@PathVariable("id") int id){
		try {
		return ResponseEntity.ok().body(albumsService.getUserAndAlbums(id));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en la busqueda de datos, " + e.getMessage());
		}
	}
	
	@Operation(summary = "Trae todos los comentarios en base a postId")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Se trae todos los comentarios filtrado por postId con exito", 
	    content = { @Content(mediaType = "application/json", 
	    schema = @Schema(implementation = CommentDto.class)) }),
	@ApiResponse(responseCode = "404", description = "Los comentarios no fueron encontradas en el servicio web", content = @Content)})
	@GetMapping("/comment/{id}")
	public ResponseEntity<Object> getcommentsByPostId(@PathVariable("id") int postId){	
		try {	
			return ResponseEntity.ok().body(commentsService.getCommentsByPostId(postId));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en la busqueda de datos, " + e.getMessage());
		}
	}
		
	/*************** Permisos ********************/
	
	@Operation(summary = "Crea un permiso")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "201", description = "Permiso creado con exito", content = @Content),
	@ApiResponse(responseCode = "400", description = "El permiso no se pudo crear por problemas en la inserccion a la base de datos", 
	    		content = @Content) })
	@PostMapping("/newpermission/{id}")
	public ResponseEntity<Object> newPermission (@RequestBody PermissionDto permissionDto, @PathVariable("id") int userId){	
		try {	
			permissionsService.insert(permissionDto, userId);
			return ResponseEntity.status(HttpStatus.CREATED).body("Permiso creado exitosamente");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el permiso, " + e.getMessage());
		}
	}
	
	@Operation(summary = "Actualiza un permiso")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "201", description = "Permiso ha sido actualizado con exito", content = @Content),
	@ApiResponse(responseCode = "400", description = "El permiso no se pudo crear por problemas en la inserccion a la base de datos", 
	    		content = @Content) })
	//solo el titular del album
	@PutMapping("/updatepermission/{id}")
	public ResponseEntity<Object> updatePermission (@RequestBody PermissionDto permissionDto, @PathVariable("id") int userId){	
		try {	
			permissionsService.update(permissionDto, userId);
			return ResponseEntity.ok().body("Permiso ha sido actualizado correctamente");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar el permiso, " + e.getMessage());
		}
	}
	
	@Operation(summary = "Trae todos los usuarios de un album especifico y un tipo de permiso")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Se trae todos los usuarios filtrado por album y permiso con exito", 
	    content = { @Content(mediaType = "application/json", 
	    schema = @Schema(implementation = UserDto.class)) }),
	@ApiResponse(responseCode = "404", description = "Los usuarios no fueron encontrados", content = @Content)})
	@GetMapping("/usersandpermissions/album={idalbum}/permission={idpermission}")
	public ResponseEntity<Object> getUsersByAlbumAndPermission (@PathVariable("idalbum") int idAlbum, @PathVariable("idpermission") int idPermission){	
		try {	
			return ResponseEntity.ok().body(permissionsService.getUsersByAlbumAndPermission(idAlbum, idPermission));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en la busqueda de datos, " + e.getMessage());
		}
	}
	
	@Operation(summary = "Trae un album si es que el usuario tiene permisos")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Se trae un album con exito", 
	    content = { @Content(mediaType = "application/json", 
	    schema = @Schema(implementation = UserDto.class)) }),
	@ApiResponse(responseCode = "404", description = "Error en la busqueda de los datos o no hay permisos", content = @Content)})
	@GetMapping("/album={idalbum}/user={iduser}")
	public ResponseEntity<Object> getByIdwithPermission(@PathVariable("idalbum") int idAlbum, @PathVariable("iduser") int userId){
		try {	
			//Obtengo el permiso del usuario que solicita ver el album
			int permission = permissionsService.getPermissionTypeByAlbumAndUser(idAlbum, userId);
			
			//Obtengo el album solicitado
			AlbumDto album = albumsService.findById(idAlbum);
			
			//verifico que tenga los permisos o que sea el dueño del album
			if(permission == 0 && album.getUserId() != userId) throw new Exception("El usuario no tiene permiso de ver el album");
			
			return ResponseEntity.ok().body(album);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en la busqueda de datos, " + e.getMessage());
		}
	}
	
	
		
}
