import fr.epita.exams.datamodel.Competitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Date;

public class TestMVD2 {
    private static final Logger logger = LogManager.getLogger(TestMVD2.class);

    public static void main(String[] args) {
        Competitor competitor = new Competitor("YourLastName", "YourFirstName", "male", "YourCountry", new Date(), 175, "Black belt", Arrays.asList("-52", "-57"));
        logger.debug(competitor.toString());
    }
}
