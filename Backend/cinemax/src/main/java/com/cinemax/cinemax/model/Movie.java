package com.cinemax.cinemax.model;

import jakarta.persistence.*;

@Entity

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    
    @Column(unique = true)

    private String title;

    private String image;

    private String info;

    private String description;

    private String category;

    private String trailer;

    public String getTrailer() {
    return trailer;
}

public void setTrailer(String trailer) {
    this.trailer = trailer;
}

    public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}