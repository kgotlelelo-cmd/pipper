package com.example.cruisemsdomain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.cruisemsdomain.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(
            name = "username",
            nullable = false
    )
    private String username;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "second_name",
            nullable = false
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
							 mappedBy = "client",
							 cascade = CascadeType.ALL,
							 orphanRemoval = true
    )
		@Builder.Default
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post){
        posts.add(post);
				post.setClient(this);
    }

	  public void removePost(Post post){
			  posts.remove(post);
			  post.setClient(null);
		}
}
