package cs544.exercise5_1;

/**
 * Created by Rabin Shrestha on 7/31/2017.
 */
public class InventoryService implements IInventoryService {
    public Integer getNumberInStock(Integer productNumber) {
        return productNumber-200;
    }
}
