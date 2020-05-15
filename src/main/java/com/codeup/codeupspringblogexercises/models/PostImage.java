package com.codeup.codeupspringblogexercises.models;

import javax.persistence.*;

@Entity
@Table(name="post_images")
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String path;

//    @ManyToOne
//    @JoinColumn (name = "post")
//    private Post post;

    public PostImage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}