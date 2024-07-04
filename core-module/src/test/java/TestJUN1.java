import fr.epita.exams.datamodel.Competitor;
import fr.epita.exams.services.JsonService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestJUN1 {

    private static final Logger logger = LogManager.getLogger(TestJUN1.class);

    @Test
    public void testReadCompetitorFromJson() {
        // Given: an instance of JsonService
        JsonService jsonService = new JsonService();

        try {
            // When: the JSON is deserialized to a Competitor object
            Competitor competitor = jsonService.readCompetitorFromJson();

            // Then: assert that the competitor is not null
            assertNotNull(competitor, "Competitor should not be null");

            // And: assert that the size of the categories list is correct
            assertEquals(2, competitor.getCategories().size(), "The number of categories should be correct.");

            logger.info("Competitor loaded successfully: " + competitor);
        } catch (Exception e) {
            logger.error("Failed to load competitor from JSON", e);
            fail("Failed to load JSON file: " + e.getMessage());
        }
    }
}
