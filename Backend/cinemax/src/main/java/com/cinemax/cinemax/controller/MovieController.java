package com.cinemax.cinemax.controller;

import com.cinemax.cinemax.model.Movie;
import com.cinemax.cinemax.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")

public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/add")

    public String addMovie(
            @RequestBody Movie movie
    ){

        movieRepository.save(movie);

        return "Movie Added";
    }

    @GetMapping("/search/{title}")

    public List<Movie> searchMovie(
            @PathVariable String title
    ){

        return movieRepository
        .findByTitleContainingIgnoreCase(
        title
        );
    }

    @GetMapping("/all")

    public List<Movie> getAllMovies(){

        return movieRepository.findAll();
    }

    @GetMapping("/category/{category}")

public List<Movie> getMoviesByCategory(
        @PathVariable String category
){

    return movieRepository
    .findByCategory(category);
}

@DeleteMapping("/delete/{id}")

public String deleteMovie(

@PathVariable int id

){

    movieRepository.deleteById(id);

    return "Movie Deleted";
}
}
