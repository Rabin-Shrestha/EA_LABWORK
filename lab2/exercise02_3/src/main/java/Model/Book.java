package Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Rabin Shrestha on 7/27/2017.
 */
@Entity
public class Book extends Product {
    @Column
    String title;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
