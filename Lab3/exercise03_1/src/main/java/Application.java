import Model.Department;
import Model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
        System.out.println("Hibernate : Lesson 2 : part 3");

        EntityManager em= emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();


        try{
            tx.begin();

            Employee e1=new Employee();
            e1.setEmployeenumber(101);
            e1.setName("Rabin Shrestha");

            Employee e2=new Employee();
            e2.setEmployeenumber(102);
            e2.setName("Pradip Shrestha");

            Department d1=new Department();
            d1.setName("Management");
            d1.setEmpList(Arrays.asList(e1,e2));


            em.persist(d1);


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
