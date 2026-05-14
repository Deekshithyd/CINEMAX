package com.cinemax.cinemax.controller;

import com.cinemax.cinemax.model.Review;

import com.cinemax.cinemax.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/reviews")

@CrossOrigin("*")

public class ReviewController {

    @Autowired

    private ReviewRepository
    reviewRepository;

    @PostMapping("/add")

    public String addReview(

    @RequestBody Review review

    ){

        reviewRepository.save(
        review
        );

        return "Review Added";
    }

    @GetMapping("/{movieTitle}")

    public List<Review>

    getReviews(

    @PathVariable String movieTitle

    ){

        return reviewRepository
        .findByMovieTitle(movieTitle);
    }

    @DeleteMapping("/delete/{id}")

public String deleteReview(

@PathVariable int id

){

    reviewRepository.deleteById(id);

    return "Review Deleted";
}
}