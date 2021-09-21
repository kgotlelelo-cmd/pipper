package com.example.cruisemsdomain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cruisemsdomain.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(
            name = "username",
            nullable = false,
            length = 20
    )
    private String username;

    @Column(
            name = "first_name",
            nullable = false,
            length = 20
    )
    private String firstName;

    @Column(
            name = "second_name",
            nullable = false,
            length = 20
    )
    private String lastName;

    @Column(
            name = "bio"
    )
    private String bio;

    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "gender"
    )
    private Gender gender;

    private LocalDateTime dateOfBirth;

    @OneToMany(
            mappedBy = "client"
    )
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
