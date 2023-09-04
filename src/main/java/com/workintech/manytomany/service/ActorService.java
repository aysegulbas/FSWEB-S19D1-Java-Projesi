package com.workintech.manytomany.service;

import com.workintech.manytomany.entity.Actor;
import com.workintech.manytomany.entity.Movie;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor delete (int id);
    Actor findById(int id);
    Actor save(Actor actor);
}
