package com.workintech.manytomany.mapping;

import com.workintech.manytomany.entity.Actor;
import com.workintech.manytomany.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorRequest {
    private Movie movie;
    private Actor actor;


}
