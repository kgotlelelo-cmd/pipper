package com.example.cruisemsdomain.entity;

import javax.persistence.*;

@Entity()
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
    Client client;

    public Post(Long id, String body, long likes) {
        this.id = id;
        this.body = body;
        this.likes = likes;
    }

    public Post(String body, long likes) {
        this.body = body;
        this.likes = likes;
    }

    public Post(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }
}
