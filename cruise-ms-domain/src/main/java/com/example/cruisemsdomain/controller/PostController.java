package com.example.cruisemsdomain.controller;

import java.util.List;

import com.example.cruisemsdomain.entity.Post;
import com.example.cruisemsdomain.service.PostService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

	private PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> getAll(){
		return ResponseEntity.ok().body(postService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> getById(@PathVariable Long id) {
		return ResponseEntity.ok().body(postService.findUsingId(id));
	}

	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable Long id){
		postService.deletePost(id);
	}
}
