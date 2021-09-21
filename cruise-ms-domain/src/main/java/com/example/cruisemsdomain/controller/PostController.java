package com.example.cruisemsdomain.controller;

import java.util.List;

import com.example.cruisemsdomain.entity.Post;
import com.example.cruisemsdomain.service.PostService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
