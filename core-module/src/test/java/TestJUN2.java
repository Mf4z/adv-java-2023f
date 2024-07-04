import fr.epita.exams.datamodel.Competitor;
import fr.epita.exams.services.JsonService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestJUN2 {

    @Test
    public void testScanAndDeserializeCompetitors() {
        // Given: A JsonService instance and a path to the directory
        JsonService jsonService = new JsonService();
        String directoryPath = "src/test/resources/competitors";

        // When: The service scans and deserializes competitors from the directory
        List<Competitor> competitors = null;
        try {
            competitors = jsonService.scanAndDeserializeCompetitors(directoryPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Then: The list of competitors should not be empty
        assertNotNull(competitors, "The list of competitors should not be null.");
        assertFalse(competitors.isEmpty(), "The list of competitors should not be empty.");

        // And: Each competitor should be properly instantiated (non-null fields check, etc.)
        assertTrue(competitors.stream().allMatch(c -> c.getFamilyName() != null && c.getGivenName() != null),
                "All competitors should have non-null essential fields.");
    }
}
