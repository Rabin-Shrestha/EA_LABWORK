package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabin Shrestha on 7/26/2017.
 */
@Embeddable
public class OrderLine {

    @Column
    int quantity;

    @Embedded
    Product product = new Product();

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public OrderLine(){}
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
