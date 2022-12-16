package com.challenge.Accenture.service;

import java.util.List;

import com.challenge.Accenture.dto.PhotoDto;

public interface PhotosService {

	public List<PhotoDto> getPhotos(int idAlbum);
	
	public List<PhotoDto> getPhotosByUser(int idUser)throws Exception;
}
