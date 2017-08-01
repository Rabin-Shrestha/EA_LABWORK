package cs544.exercise5_1;

public interface IProductService {
	public Product getProduct(int productNumber);
	public Integer getNumberInStock(Integer productNumber);
	//public void setInventoryService(IInventoryService inventoryService);
}
