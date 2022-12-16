package com.challenge.Accenture.service;

import java.util.List;

import com.challenge.Accenture.dto.AlbumDto;

public interface AlbumsService {

	public List<AlbumDto> getAlbums();
	
	public AlbumDto findById(int albumId);
	
	public List<AlbumDto> getUserAndAlbums(int id);

}
