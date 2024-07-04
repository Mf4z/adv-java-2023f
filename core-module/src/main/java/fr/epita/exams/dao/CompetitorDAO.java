package fr.epita.exams.dao;

import fr.epita.exams.datamodel.Competitor;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class CompetitorDAO {

    private final DataSource dataSource;

    public CompetitorDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Competitor competitor) throws SQLException {
        String sql = "INSERT INTO COMPETITOR (family_name, given_name, gender, country, birth_date, height, belt) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, competitor.getFamilyName());
            statement.setString(2, competitor.getGivenName());
            statement.setString(3, competitor.getGender());
            statement.setString(4, competitor.getCountry());
            statement.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(competitor.getBirthDate()));  // assuming birthDate is a java.util.Date
            statement.setInt(6, competitor.getHeight());
            statement.setString(7, competitor.getBelt());
            statement.executeUpdate();
        }
    }
}
