package cs544.exercise5_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
	public static void main(String[] args) {
		// Injecting productService here in App.js
		ApplicationContext context=new ClassPathXmlApplicationContext("springConfig.xml");
		IProductService productService=context.getBean("productService",ProductService.class);
		//IProductService productService = new ProductService(); // We no longer need to create a object of service here

		System.out.println("We have "+productService.getNumberInStock(423)+" product(s) in stock with product number 432 ");
		System.out.println("We have "+productService.getNumberInStock(239)+" product(s) in stock with product number 239 ");

		Product product1 = productService.getProduct(423);
		if (product1 != null) {
			System.out.println(product1.toString());
		}
		Product product2 = productService.getProduct(239);
		if (product2 != null) {
			System.out.println(product2.toString());
		}




		/*IProductService productService = new ProductService();
		Product product1 = productService.getProduct(423);
		if (product1 != null) {
			System.out.println(product1.toString());
		}
		Product product2 = productService.getProduct(239);
		if (product2 != null) {
			System.out.println(product2.toString());
		}
*/
	}
}
