package Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Rabin Shrestha on 7/27/2017.
 */
@Entity
public class CD extends Product {
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Column

    String artist;


}
