package cs544.exercise11_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
	public static void main(String[] args) {

		/*IBookService bookService = new BookService();
		bookService.buy(new Book("123433267", "Harry Potter and the Order of the Phoenix", "J.K. Rowling"));
        bookService.buy(new Book("888832678", "Harry Potter and the Sorcerer's Stone" , "J.K. Rowling"));
        bookService.buy(new Book("999923156", "Harry Potter and the Goblet of Fire" ,"J.K. Rowling"));
	*/

		ApplicationContext context= new ClassPathXmlApplicationContext("springconfig.xml");
		IBookService bookService=context.getBean("bookService",IBookService.class);
		bookService.buy(new Book("123433267", "Harry Potter and the Order of the Phoenix", "J.K. Rowling"));
		bookService.buy(new Book("888832678", "Harry Potter and the Sorcerer's Stone" , "J.K. Rowling"));
		bookService.buy(new Book("999923156", "Harry Potter and the Goblet of Fire" ,"J.K. Rowling"));




	}
}
