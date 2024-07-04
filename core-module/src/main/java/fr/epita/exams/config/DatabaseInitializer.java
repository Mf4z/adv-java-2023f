package fr.epita.exams.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
//@ComponentScan(basePackages = "fr.epita.exams.config")
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS COMPETITOR (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "family_name VARCHAR(255), " +
                    "given_name VARCHAR(255), " +
                    "gender VARCHAR(50), " +
                    "country VARCHAR(255), " +
                    "birth_date DATE, " +
                    "height INT, " +
                    "belt VARCHAR(255))");
        }
    }
}

