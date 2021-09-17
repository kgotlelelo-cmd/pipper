package com.example.cruisemsdomain.Entity;

import com.example.cruisemsdomain.model.Gender;
import com.example.cruisemsdomain.model.post;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data //lombok
@AllArgsConstructor
@Document(collection = "client")
public class client {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String firstName;
    private String lastName;
    private String bio;

    @Indexed(unique = true)
    private String email;

    private Gender gender;
    private LocalDateTime dateOfBirth;

    private List<post> posts;

    public client(
            String username,
            String firstName,
            String lastName,
            String bio,
            String email,
            Gender gender,
            LocalDateTime dateOfBirth,
            List<post> posts
    ) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.posts = posts;
    }

    public client(
            String username,
            String firstName,
            String lastName,
            String bio,
            String email,
            Gender gender,
            LocalDateTime dateOfBirth
    ) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public client(){

    }

    public void addPost(post newPost){
        this.posts.add(newPost);
    }
}