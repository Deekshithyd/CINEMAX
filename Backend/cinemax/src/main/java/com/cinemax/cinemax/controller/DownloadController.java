package com.cinemax.cinemax.controller;

import com.cinemax.cinemax.model.Download;
import com.cinemax.cinemax.repository.DownloadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/downloads")
@CrossOrigin("*")

public class DownloadController {

    @Autowired
    private DownloadRepository downloadRepository;

    @PostMapping("/add")

    public String addMovie(
            @RequestBody Download download
    ){

        Download existingMovie =

        downloadRepository.findByMovieTitle(
            download.getMovieTitle()
        );

        if(existingMovie != null){

            return "Already Downloaded";
        }

        downloadRepository.save(download);

        return "Movie Downloaded";
    }

    @GetMapping("/all")

    public List<Download> getAllMovies(){

        return downloadRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")

    public String deleteMovie(
            @PathVariable int id
    ){

        downloadRepository.deleteById(id);

        return "Movie Deleted";
    }
}