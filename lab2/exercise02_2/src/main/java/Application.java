import Model.Order;
import Model.OrderLine;
import Model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.Arrays;

/**
 * Created by Rabin Shrestha on 7/26/2017.
 */
public class Application
{

    private static EntityManagerFactory emf;
    static{
        try{
            emf= Persistence.createEntityManagerFactory("cs544");

        }catch (Throwable ex)
        {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Hibernate : Lesson 2");

        EntityManager em= emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();


        try{

            tx.begin();
            OrderLine myOrderLine=new OrderLine();
            myOrderLine.setQuantity(3);
            myOrderLine.setProduct(new Product("Pen","Nepali Pen"));

            Order myOrder=new Order();

            myOrder.setOrderDate(new Date(2017,02,12));
            myOrder.setOrderLineList(Arrays.asList(myOrderLine));

            em.persist(myOrder);

            tx.commit();
        }
        catch (Throwable ex)
        {
            if(tx!=null && tx.isActive())tx.rollback();
        }
        finally {
            if(em!=null && em.isOpen())em.close();
        }

    }
}
