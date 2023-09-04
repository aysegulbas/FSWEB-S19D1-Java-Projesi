package com.workintech.manytomany.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name="actor",schema="spring")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="gender")
    private String gender;
    @Column(name="birthDate")
    private LocalDate birthDate;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="movie-actor",schema="spring",
    joinColumns = @JoinColumn(name="actor_id"),
    inverseJoinColumns = @JoinColumn(name="movie_id"))
    private List<Movie> movies;
    public void addMovie(Movie movie){
        if(movies==null){
            movies=new ArrayList<>();
        }movies.add(movie);
    }

}
