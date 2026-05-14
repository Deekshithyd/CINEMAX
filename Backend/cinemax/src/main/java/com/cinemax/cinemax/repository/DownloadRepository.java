package com.cinemax.cinemax.repository;

import com.cinemax.cinemax.model.Download;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadRepository
extends JpaRepository<Download, Integer> {

    Download findByMovieTitle(String movieTitle);
}