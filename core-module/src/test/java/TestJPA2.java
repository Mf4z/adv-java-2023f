package fr.epita.exams;

import fr.epita.exams.config.JpaConfig;
import fr.epita.exams.datamodel.Competitor;
import fr.epita.exams.repository.CompetitorRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class TestJPA2 {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class)) {
            CompetitorRepository repo = context.getBean(CompetitorRepository.class);

            Competitor competitor = new Competitor("Doe", "John", "Male", "USA", new Date(), 180, "Black", List.of("Category1", "Category2"));

            repo.createCompetitor(competitor);

            System.out.println("Competitor created successfully.");
        }
    }
}
