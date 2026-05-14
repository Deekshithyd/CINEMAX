package com.cinemax.cinemax.repository;

import com.cinemax.cinemax.model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository
extends JpaRepository<Movie, Integer> {

   List<Movie> findByTitleContainingIgnoreCase(
   String title
   );

   List<Movie> findByCategory(
   String category
   );
}