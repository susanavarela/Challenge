package com.challenge.Accenture.service;

import java.util.List;

import com.challenge.Accenture.dto.AlbumDto;
import com.challenge.Accenture.dto.CommentDto;
import com.challenge.Accenture.dto.PhotoDto;
import com.challenge.Accenture.dto.UserDto;

public interface JsonPlaceHolderService {

	 public List<UserDto> getUsers();
	 
	 public List<AlbumDto> getAlbums();
	 
	 public List<PhotoDto> getPhotos(int idAlbum);
	 
	 public List<AlbumDto> getUserAndAlbums(int idUser);
	 
	 public AlbumDto getAlbumId(int albumId);
	 
	 public UserDto getUserId(int UsertId);
	 
	 public List<CommentDto> getCommentByPostId(int postId);
	 
}
