package com.cinemax.cinemax.controller;

import com.cinemax.cinemax.model.Watchlist;
import com.cinemax.cinemax.repository.WatchlistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
@CrossOrigin("*")

public class WatchlistController {

    @Autowired
    private WatchlistRepository watchlistRepository;

    @PostMapping("/add")

    public String addMovie(
            @RequestBody Watchlist watchlist
    ){

        Watchlist existingMovie =

        watchlistRepository.findByMovieTitle(
            watchlist.getMovieTitle()
        );

        if(existingMovie != null){

            return "Already Added";
        }

        watchlistRepository.save(watchlist);

        return "Movie Added";
    }

    @GetMapping("/all")

    public List<Watchlist> getAllMovies(){

        return watchlistRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")

    public String deleteMovie(
            @PathVariable int id
    ){

        watchlistRepository.deleteById(id);

        return "Movie Deleted";
    }
}