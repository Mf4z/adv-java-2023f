import fr.epita.exams.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSPR1 {

    public static void main(String[] args) {
        // Load the Spring context based on the AppConfig
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            // Retrieve the bean by type
            String testString = context.getBean(String.class);
            System.out.println(testString);  // Output the string to verify the injection
        }
    }
}
