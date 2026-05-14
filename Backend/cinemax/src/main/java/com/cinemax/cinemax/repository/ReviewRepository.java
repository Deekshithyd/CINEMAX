package com.cinemax.cinemax.repository;

import com.cinemax.cinemax.model.Review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository

extends JpaRepository<Review,Integer>{

    List<Review>

    findByMovieTitle(
    String movieTitle
    );
}