import Model.Book;
import Model.CD;
import Model.DVD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        System.out.println("Hibernate : Lesson 2 : part 3");

        EntityManager em= emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();


        try{

            tx.begin();
            Book book1=new Book();
            book1.setName("Hibernate Book");
            book1.setDescription("Very good book");
            book1.setTitle("Hibernate in detail");

            CD cd1=new CD();
            cd1.setName("cd 1");
            cd1.setDescription("cd 1 : description");
            cd1.setArtist("Rabin Shrestha");

            DVD dv1=new DVD();
            dv1.setName("DVD 1");
            dv1.setDescription("DVD 1 : description");
            dv1.setGenre("2009");

            em.persist(book1);
            em.persist(cd1);
            em.persist(dv1);
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
