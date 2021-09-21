package com.example.cruisemsdomain.repository;

import com.example.cruisemsdomain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
