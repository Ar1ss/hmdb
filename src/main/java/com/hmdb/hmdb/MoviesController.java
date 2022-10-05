package com.hmdb.hmdb;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MoviesController {
    
    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
          return Movie.movies;
     }

     @PostMapping("/movies")
     public Movie createMovie(@RequestBody Movie movie) {
         return movie;
     }
}

class Movie {


    private static Integer  currentId = 1;
    public static ArrayList<Movie> movies = new ArrayList<>();

    public Integer id;  
    public String title;
    public String description;
    public Integer year;

    static{
        new Movie( currentId, "The Godfather", "The Godfather is back", 1972); 
        new Movie( currentId, "The Shawshank Redemption", "The Shawshank Redemption", 1994);
        new Movie( currentId, "The Dark Knight", "The Dark Knight", 2008);
        new Movie( currentId, "The Lord of the Rings: The Return of the King", "The Lord of the Rings: The Return of the King", 2003);
    }

    public Movie(Integer id, String title, String description, Integer year) {
    
        this.id = Movie.currentId++;
        this.title = title;
        this.description = description;
        this.year = year;
        

        Movie.movies.add(this);
    }
}

