package com.challenge.Accenture.service.implementation;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.challenge.Accenture.dto.AlbumDto;
import com.challenge.Accenture.dto.PhotoDto;
import com.challenge.Accenture.dto.UserDto;
import com.challenge.Accenture.service.JsonPlaceHolderService;

//Service para consumir de un servicio externo
@Service("JsonPlaceHolderServiceImpl")
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService{

	private final WebClient webClient;

    public JsonPlaceHolderServiceImpl(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://jsonplaceholder.typicode.com/").build();
    }
	 
	public List<UserDto> getUsers() {
	     return webClient
	    		.get()
	            .uri("/users")
	            .retrieve()
	            .bodyToMono(new ParameterizedTypeReference<List<UserDto>>() {}).block();
	    }
	    
	public List<AlbumDto> getAlbums() {
	     return webClient
	    		.get()
	            .uri("/albums")
	            .retrieve()
	            .bodyToMono(new ParameterizedTypeReference<List<AlbumDto>>() {}).block();
	    }
	 
	public List<PhotoDto> getPhotos(int idAlbum) {
		 String url = "/photos?albumId=" + idAlbum;
	     return webClient
	    		.get()
	            .uri(url)
	            .retrieve()
	            .bodyToMono(new ParameterizedTypeReference<List<PhotoDto>>() {}).block();
	    }
	 
	public List<AlbumDto> getUserAndAlbums(int idUser) {
		 String url = "/posts?userId=" + idUser;
		 return webClient
	    		.get()
	            .uri(url)
	            .retrieve()
	            .bodyToMono(new ParameterizedTypeReference<List<AlbumDto>>() {}).block();
	    }

	@Override
	public AlbumDto getAlbumId(int albumId) {
		List<AlbumDto> albums = getAlbums();
		AlbumDto album = new AlbumDto();
		boolean flag = false;
		int i = 0;
		while(!flag && albums.size() > i) {
			if(albums.get(i).getId() == albumId) {
				flag = true;
			}
			i++;
		}
		
		if(flag) {
			album = albums.get(i-1);
		}else {
			album.setId(0);
		}
		return album;
	}

	@Override
	public UserDto getUserId(int UsertId) {
		List<UserDto> Users = getUsers();
		UserDto User = new UserDto();
		boolean flag = false;
		int i = 0;
		while(!flag && Users.size() > i) {
			if(Users.get(i).getId() == UsertId) {
				flag = true;
			}
			i++;
		}
		
		if(flag) {
			User = Users.get(i-1);
		}
		return User;
	}

	
	
	 
	
}