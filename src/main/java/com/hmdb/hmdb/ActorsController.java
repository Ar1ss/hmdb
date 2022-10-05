package com.hmdb.hmdb;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorsController {
    
    @GetMapping("/actors")
   public ArrayList<Actor> getActors() {
        return Actor.actors;
    }

    @PostMapping("/actors")
    public Actor createActor(@RequestBody Actor actor) {
        return actor;
    }
}

class Actor {


    private static Integer  currentId = 1;
    public static ArrayList<Actor> actors = new ArrayList<>();

    public Integer id;  
    public String firstName;
    public String lastName;
    public Integer yearOfBirth;
    public Integer movieId;

    static{
        new Actor( currentId, "Marlon", "Brando", 1924, 1);
        new Actor( currentId, "Al", "Pacino", 1940, 1);
        new Actor( currentId, "Robert", "De Niro", 1943, 2);
        new Actor( currentId, "Christian", "Bale", 1974, 3);
    }

    public Actor(Integer id, String firstName, String lastName, Integer yearOfBirth, Integer movieId) {
    
        this.id = Actor.currentId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.movieId = movieId;

        Actor.actors.add(this);
    }

}