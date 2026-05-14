package com.cinemax.cinemax.controller;

import com.cinemax.cinemax.model.Recent;

import com.cinemax.cinemax.repository.RecentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/recent")

@CrossOrigin("*")

public class RecentController {

    @Autowired

    private RecentRepository
    recentRepository;

    @PostMapping("/add")

    public String addRecent(

    @RequestBody Recent recent

    ){

        recentRepository.save(
        recent
        );

        return "Recent Saved";
    }

    @GetMapping("/{username}")

    public List<Recent>

    getRecentMovies(

    @PathVariable String username

    ){

        return recentRepository
        .findByUsername(username);
    }
}