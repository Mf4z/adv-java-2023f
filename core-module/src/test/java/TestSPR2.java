import fr.epita.exams.config.AppConfig;
import fr.epita.exams.dao.CompetitorDAO;
import fr.epita.exams.datamodel.Competitor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Date;

public class TestSPR2 {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            CompetitorDAO dao = context.getBean(CompetitorDAO.class);

            // Create a new competitor with full details
            Competitor competitor = new Competitor("Doe", "John", "male", "USA", new Date(), 180, "Red belt", Arrays.asList("-52", "-57"));
            dao.save(competitor);

            System.out.println("Competitor saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
