package com.example.cruisemsdomain.model;

import org.springframework.data.annotation.Id;

public class Post {

    @Id
    private int id;

    private String body;

    private long likes;

    public Post(int id, String body, long likes) {
        this.id = id;
        this.body = body;
        this.likes = likes;
    }

    public Post(String body, long likes) {
        this.body = body;
        this.likes = likes;
    }

    public Post(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
