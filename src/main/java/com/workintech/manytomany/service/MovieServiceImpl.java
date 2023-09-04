package com.workintech.manytomany.service;

import com.workintech.manytomany.dao.MovieRepository;
import com.workintech.manytomany.entity.Actor;
import com.workintech.manytomany.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;
@Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie delete(int id) {
        Movie movie = findById(id);
        movieRepository.delete(movie);
        return movie;

    }

    @Override
    public Movie findById(int id) {

        Optional<Movie>optionalMovie=movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            optionalMovie.get();
        }return null;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
