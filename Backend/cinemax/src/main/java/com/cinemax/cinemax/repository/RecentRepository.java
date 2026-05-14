package com.cinemax.cinemax.repository;

import com.cinemax.cinemax.model.Recent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecentRepository

extends JpaRepository<Recent,Integer>{

    List<Recent>

    findByUsername(
    String username
    );
}