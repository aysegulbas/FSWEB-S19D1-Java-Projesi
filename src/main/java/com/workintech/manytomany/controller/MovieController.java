package com.workintech.manytomany.controller;

import com.workintech.manytomany.entity.Actor;
import com.workintech.manytomany.entity.Movie;
import com.workintech.manytomany.mapping.ActorResponse;
import com.workintech.manytomany.mapping.MovieActorRequest;
import com.workintech.manytomany.mapping.MovieActorResponse;
import com.workintech.manytomany.mapping.MovieResponse;
import com.workintech.manytomany.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;
@Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/")
    public List<MovieResponse> findAll() {//içinde actorlar olduğu için loopa girdi, bizim istediğimiz şekilde array halinde dönsün dedik
        List<MovieResponse> movieResponses = new ArrayList<>();
        List<Movie> movies = movieService.findAll();
        for (Movie movie : movies) {
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                    movie.getRating(), movie.getReleaseDate()));
        }
        return movieResponses;
    }
    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id) {
        Movie foundMovie = movieService.findById(id);
        return new MovieResponse(foundMovie.getId(), foundMovie.getName(), foundMovie.getDirectorName(),
                foundMovie.getRating(), foundMovie.getReleaseDate());

    }
    @PostMapping("/")
    public MovieActorResponse save(@RequestBody MovieActorRequest movieActorRequest){
    Movie movie=movieActorRequest.getMovie();
        Actor actor=movieActorRequest.getActor();
        movie.addActor(actor);
        Movie savedMovie=movieService.save(movie);
        return new MovieActorResponse(savedMovie,actor.getId(),actor.getFirstName(),actor.getLastName(),actor.getBirthDate());
    }
    @PostMapping("/addActor/{movieId}")
    public List<ActorResponse> addActor(@RequestBody List<Actor> actors, @PathVariable int movieId) {
        Movie movie = movieService.findById(movieId);
        movie.addAllActor(actors);
        Movie savedMovie = movieService.save(movie);
        List<ActorResponse>actorResponses=new ArrayList<>();
        for(Actor actor: savedMovie.getActors()){
            actorResponses.add(new ActorResponse(actor.getId(),actor.getFirstName(),actor.getLastName(),actor.getBirthDate()));
        }return actorResponses;
    }
    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie, @PathVariable int id) {
        Movie foundMovie = movieService.findById(id);
        movie.setId(id);
        movie.setActors(foundMovie.getActors());//bunu yazmazsan boş hali updateli hali sanar ve tüm actorleri siler
        Movie updatedMovie = movieService.save(movie);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }
    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable int id) {
        Movie movie = movieService.delete(id);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }

}

