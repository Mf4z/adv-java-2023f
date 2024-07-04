import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "fr.epita.exams")
public class TestRST1 {

    public static void main(String[] args) {
        SpringApplication.run(TestRST1.class, args);
    }
}