package Model;

import javax.persistence.*;

/**
 * Created by Rabin Shrestha on 7/26/2017.
 */
@Embeddable
public class Product {

    @Column
    String name;
    @Column
    String description;
    public Product(){}

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
