package fr.epita.exams.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.epita.exams.datamodel.Competitor;

import java.io.IOException;
import java.io.InputStream;

public class JsonService {

    public Competitor readCompetitorFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("competitor.json");
        if (inputStream == null) {
            throw new IOException("Cannot find 'competitor.json' file in resources.");
        }
        return mapper.readValue(inputStream, Competitor.class);
    }
}
