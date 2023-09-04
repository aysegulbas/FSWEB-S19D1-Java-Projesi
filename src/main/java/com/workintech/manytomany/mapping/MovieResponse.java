package com.workintech.manytomany.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private int movieId;
    private String name;
    private String directorName;
    private int rating;
    private LocalDate releaseDate;
}
