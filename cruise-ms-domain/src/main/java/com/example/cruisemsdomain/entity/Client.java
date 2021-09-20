package com.example.cruisemsdomain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cruisemsdomain.model.Gender;
import com.example.cruisemsdomain.entity.Post;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "client")
public class Client {

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
    private List<Post> posts;

    public Client(
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

    public void addPost(Post newPost){
        this.posts.add(newPost);
    }
}
