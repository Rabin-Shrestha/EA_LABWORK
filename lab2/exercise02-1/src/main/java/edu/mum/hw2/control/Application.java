package edu.mum.hw2.control;
import edu.mum.hw2.control.model.Actor;
import edu.mum.hw2.control.model.Movie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.File;
import java.util.Arrays;
import java.util.TreeSet;



public class Application {

    private static EntityManagerFactory emf;

    static {
        try {
            // Creating EmtityMangerfactory() for databae cs544
            emf = Persistence.createEntityManagerFactory("cs544");
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {

        addMovies();
        printMoviesReport();
        emf.close();
    }

    private static void printMoviesReport() {
        // TODO Auto-generated method stub
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            //
            Movie firstMovie=em.find(Movie.class,1);
            System.out.println("************ Printing the movie detail ***************");
            System.out.println("Movie Name :"+firstMovie.getName());
            System.out.println("Movie Rating :"+firstMovie.getRating());
            System.out.println("Movie Cover :"+firstMovie.getCover());

            System.out.println("************ Movie category ***************");
            for (String cat:firstMovie.getCategories()) {
                System.out.println("Category : "+ cat);
            }

            System.out.println("************ List of comments ***************");
            for (String comment:firstMovie.getComments()) {
                System.out.println("Comment : "+ comment);
            }

            System.out.println("************ List of Actors ***************");
            for (Actor actor:firstMovie.getActors()) {
                System.out.println("Name : "+ actor.getName());
                System.out.println("Rating : "+ actor.getCharacter());
                System.out.println("Character : "+ actor.getCharacter());
                System.out.println("============================================");
            }
            System.out.println("Cover pic"+firstMovie.getCover());



        } catch (Throwable e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            if (em != null && em.isOpen()) em.close();
        }

    }

    private static void addMovies() {
        // creating Entity manger
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            // TODO your code
            Movie movie = new Movie();
            movie.setName("Talakjung vs Tulke");
            movie.setRating(5);

            // creating list of actors
            Actor actor1 = new Actor(4, "Rajesh Hamal", "Hero");
            Actor actor2 = new Actor(4, "Priyanka Karki", "Heroine");
            Actor actor3 = new Actor(5, "Rabin", "villain");
            Actor actor4 = new Actor(3, "Ishan Kuthhu", "Hero");

            movie.setActors(Arrays.asList(actor1, actor2, actor3, actor4));
            // Creating list of comments
            movie.setComments(Arrays.asList("This movie is super fantastic", "I liked the story", "Acting of Ishan was just WOW"));
            movie.setCategories(new TreeSet<String>(Arrays.asList("Comedy", "Romantic")));

            // assign cover picture
           File file = new File("D:\\EA\\coverpic.jpg");
            byte[] imageData = new byte[(int) file.length()];
            movie.setCover(imageData);

            // saving data into database
            em.persist(movie);

            tx.commit();
            // finally commiting it
        } catch (Throwable e) {
            if ((tx != null) && (tx.isActive())) tx.rollback();
        } finally {
            if ((em != null) && (em.isOpen())) em.close();
        }
    }

}
