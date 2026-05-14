package com.cinemax.cinemax.model;

import jakarta.persistence.*;

@Entity

public class Recent {

    @Id

    @GeneratedValue(
    strategy = GenerationType.IDENTITY
    )

    private int id;

    private String username;

    private String title;

    private String image;

    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(
    String username
    ) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(
    String title
    ) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(
    String image
    ) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(
    String info
    ) {
        this.info = info;
    }
}