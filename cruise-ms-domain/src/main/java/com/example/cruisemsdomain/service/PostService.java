package com.example.cruisemsdomain.service;

import java.util.List;

import com.example.cruisemsdomain.entity.Post;
import com.example.cruisemsdomain.repository.PostRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostService {
	
	private PostRepository postRepository;

	
	public List<Post> findAll(){
		return postRepository.findAll();
	}

	public Post findUsingId(Long id){
		return postRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found."));
	}
}
