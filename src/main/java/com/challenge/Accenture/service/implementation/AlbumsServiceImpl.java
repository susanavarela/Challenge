package com.challenge.Accenture.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.Accenture.dto.AlbumDto;
import com.challenge.Accenture.service.AlbumsService;
import com.challenge.Accenture.service.JsonPlaceHolderService;

@Service("AlbumsServiceImpl")
public class AlbumsServiceImpl implements AlbumsService{

	@Autowired
	private JsonPlaceHolderService jsonPlaceHolderService ;

	@Override
	public List<AlbumDto> getAlbums() {
		
		return jsonPlaceHolderService.getAlbums();
	}

	@Override
	public AlbumDto findById(int albumId) {
		
		return jsonPlaceHolderService.getAlbumId(albumId);
	}

	@Override
	public List<AlbumDto> getUserAndAlbums(int id) {
		return jsonPlaceHolderService.getUserAndAlbums(id);
	}
	

}
