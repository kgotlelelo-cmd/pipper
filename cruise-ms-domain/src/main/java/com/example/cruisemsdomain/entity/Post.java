package com.example.cruisemsdomain.entity;

import javax.persistence.*;

@Entity()
@Table(name = "POST")
public class Post {

    @Id
    @SequenceGenerator(
            name ="POST_sequence",
            sequenceName = "POST_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "POST_sequence"
    )
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
            name = "clientId",
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
