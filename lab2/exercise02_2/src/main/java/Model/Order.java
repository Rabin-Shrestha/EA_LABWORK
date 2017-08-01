package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Rabin Shrestha on 7/26/2017.
 */
@Entity(name = "tbl_Order")
public class Order {
    @Id
    @GeneratedValue
    int id;

    @Column(name = "orderDate")
    Date orderDate;

    @ElementCollection
    List<OrderLine> orderLineList=new ArrayList<OrderLine>();

    public Date getOrderDate() {
        return orderDate;
    }

    public Order(){}

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }


}
