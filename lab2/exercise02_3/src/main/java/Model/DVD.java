package Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Rabin Shrestha on 7/27/2017.
 */
@Entity
public class DVD extends Product {
    @Column
    String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
