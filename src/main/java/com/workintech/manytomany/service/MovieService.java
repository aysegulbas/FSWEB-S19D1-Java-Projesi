package com.workintech.manytomany.service;

import com.workintech.manytomany.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie delete (int id);
    Movie findById(int id);
    Movie save(Movie movie);
}
