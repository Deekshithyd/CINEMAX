package com.cinemax.cinemax.repository;

import com.cinemax.cinemax.model.Watchlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository
extends JpaRepository<Watchlist, Integer> {

    Watchlist findByMovieTitle(String movieTitle);
}