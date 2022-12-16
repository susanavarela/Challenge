package com.challenge.Accenture.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.Accenture.dto.AlbumDto;
import com.challenge.Accenture.dto.PhotoDto;
import com.challenge.Accenture.service.AlbumsService;
import com.challenge.Accenture.service.JsonPlaceHolderService;
import com.challenge.Accenture.service.PhotosService;

@Service("PhotoServiceImpl")
public class PhotoServiceImpl implements PhotosService{

	@Autowired
	private AlbumsService albumsService ;
	
	@Autowired
	private JsonPlaceHolderService jsonPlaceHolderService;
	
	@Override
	public List<PhotoDto> getPhotos(int idAlbum) {
		return jsonPlaceHolderService.getPhotos(idAlbum);
	}

	@Override
	public List<PhotoDto> getPhotosByUser(int idUser) throws Exception{
		List<AlbumDto> albums = albumsService.getUserAndAlbums(idUser);
		if(albums.isEmpty())throw new Exception("El usuario no tiene albunes");
		List<PhotoDto> photos = new ArrayList<PhotoDto>();
		
		for(AlbumDto albumDto : albums) {
			List<PhotoDto> photosDto = getPhotos(albumDto.getId());
			for(PhotoDto aux : photosDto) {
				photos.add(aux);
			}
			
		}
		
		return photos;
	}

	
}
