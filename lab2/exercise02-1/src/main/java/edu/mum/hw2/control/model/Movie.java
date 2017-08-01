package edu.mum.hw2.control.model;
import javax.persistence.*;
import java.util.*;

/**
 * Created by Rabin Shrestha on 7/25/2017.
 */

@Entity
public class Movie {
    @Id
    @GeneratedValue
    int id;
    String name;
    int rating;
    @Lob
    @Column(columnDefinition = "mediumblob")
    byte[] Cover;

    @ElementCollection
    Set<String> categories=new HashSet<String>();

    @ElementCollection
    List<String> comments=new ArrayList<>();

    @ElementCollection
    List<Actor> actors=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public byte[] getCover() {
        return Cover;
    }

    public void setCover(byte[] cover) {
        Cover = cover;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Movie(){}

}

