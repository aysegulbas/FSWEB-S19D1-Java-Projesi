package com.workintech.manytomany.dao;

import com.workintech.manytomany.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
