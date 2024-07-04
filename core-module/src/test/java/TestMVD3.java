import fr.epita.exams.datamodel.Competitor;
import fr.epita.exams.services.JsonService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestMVD3 {

    private static final Logger logger = LogManager.getLogger(TestMVD3.class);

    @Test
    public void testReadCompetitorFromJson() {
        JsonService jsonService = new JsonService();
        try {
            Competitor competitor = jsonService.readCompetitorFromJson();
            assertNotNull(competitor, "Competitor should not be null");
            logger.info("Competitor loaded successfully: " + competitor);
        } catch (Exception e) {
            logger.error("Failed to load competitor from JSON", e);
            fail("Failed to load JSON file: " + e.getMessage());
        }
    }
}
