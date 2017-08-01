package edu.mum.hw2.control.model;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Rabin Shrestha on 7/25/2017.
 */

@Embeddable
public class Actor {
    @Column(name="rating")
    Integer rating;
    @Column(name="actorName")
    String name;
    @Column(name="actorRole")
    String character;
    public Actor(){}

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
    public Actor(Integer rating, String name, String character) {
        this.rating = rating;
        this.name = name;
        this.character = character;
    }
}



/*

package edu.mum.hw2.control.model;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Actor {

    @Column(name = "actorName")
    private String name;

    @Column(name = "actorRating")
    private int rating;

    @Column(name = "role")
    private String character;

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
    public String getCharacter() {
        return character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }


}*/
