package com.challenge.Accenture.service;

import java.util.List;

import com.challenge.Accenture.dto.CommentDto;

public interface CommentsService {

	public List<CommentDto> getCommentsByPostId(int postId)throws Exception;
	
}
