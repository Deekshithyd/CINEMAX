package com.cinemax.cinemax.model;

import jakarta.persistence.*;

@Entity

public class Review {

    @Id

    @GeneratedValue(
    strategy = GenerationType.IDENTITY
    )

    private int id;

    private String username;

    private String movieTitle;

    private int rating;

    private String comment;

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

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(
    String movieTitle
    ) {
        this.movieTitle = movieTitle;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(
    int rating
    ) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(
    String comment
    ) {
        this.comment = comment;
    }
}