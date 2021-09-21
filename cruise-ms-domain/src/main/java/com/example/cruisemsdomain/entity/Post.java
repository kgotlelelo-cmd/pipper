package com.example.cruisemsdomain.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Long id;

    @Column(
            name = "body"
    )
    private String body;

    @Column(
            name = "likes"
    )
    private long likes;

    @ManyToOne
    @JoinColumn(
            name = "client_id",
            nullable = false
    )
    private Client client;
}
