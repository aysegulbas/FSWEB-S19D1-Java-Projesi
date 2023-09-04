package com.workintech.manytomany.controller;

import com.workintech.manytomany.dao.ActorRepository;
import com.workintech.manytomany.dao.MovieRepository;
import com.workintech.manytomany.entity.Actor;
import com.workintech.manytomany.entity.Movie;
import com.workintech.manytomany.mapping.ActorResponse;
import com.workintech.manytomany.mapping.MovieResponse;
import com.workintech.manytomany.service.ActorService;
import com.workintech.manytomany.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private ActorService actorService;
    private MovieService movieService;

    @Autowired
    public ActorController(ActorService actorService, MovieService movieService) {
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<ActorResponse> fidAll() {
        List<Actor> actors = actorService.findAll();
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor : actors) {
            List<MovieResponse> movieResponses = new ArrayList<>();
            for (Movie movie : actor.getMovies()) {
                movieResponses.add(new MovieResponse(movie.getId(), movie.getName()));
            }
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), movieResponses));
        }return actorResponses;

    }
    @PostMapping("/")
    public ActorResponse save(@RequestBody Actor actor){
        Actor
    }
}
