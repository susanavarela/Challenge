package com.challenge.Accenture.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.Accenture.dto.CommentDto;
import com.challenge.Accenture.service.CommentsService;
import com.challenge.Accenture.service.JsonPlaceHolderService;

@Service("CommentsServiceImpl")
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	private JsonPlaceHolderService jsonPlaceHolderService ;
	
	//Obtiene una lista de comentarios filtrando por postId
	@Override
	public List<CommentDto> getCommentsByPostId(int postId) throws Exception {
		return jsonPlaceHolderService.getCommentByPostId(postId);
	}

}
