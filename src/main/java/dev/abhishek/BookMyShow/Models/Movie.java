package dev.abhishek.BookMyShow.Models;

import dev.abhishek.BookMyShow.Models.Constant.MovieFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    @ManyToMany
    private List<Actor> actors;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeatures> movieFeatures;

    public Movie() {
    }

    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
