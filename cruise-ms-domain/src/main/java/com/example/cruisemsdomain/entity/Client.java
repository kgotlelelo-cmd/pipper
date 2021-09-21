package com.example.cruisemsdomain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cruisemsdomain.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data //lombok
@AllArgsConstructor
@Entity()
@Table(name = "CLIENT")
public class Client {

    @Id
    @SequenceGenerator(
            name = "CLIENT_sequence",
            sequenceName = "CLIENT_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_sequence"
    )

    @Column(name = "clientId")
    private Long id;

    @Column(
            name = "username",
            nullable = false,
            length = 20
    )
    private String username;

    @Column(
            name = "firstName",
            nullable = false,
            length = 20
    )
    private String firstName;

    @Column(
            name = "secondName",
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
            LocalDateTime dateOfBirth,
            List<Post> posts
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

    public Client(){

    }

    public void addPost(Post newPost){
        this.posts.add(newPost);
    }
}
