import fr.epita.exams.config.JpaConfig;
import fr.epita.exams.datamodel.Competitor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.List;

public class TestJPA1 {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class)) {
            EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
            EntityManager em = emf.createEntityManager();

            Competitor competitor = new Competitor("Doe", "John", "Male", "USA", new Date(), 180, "Black", List.of("Category1", "Category2"));

            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.persist(competitor);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            } finally {
                em.close();
            }

            System.out.println("Competitor persisted successfully.");
        }
    }
}
