package fr.epita.exams.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.epita.exams.datamodel.Competitor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonService {
    private ObjectMapper mapper;
    public JsonService() {
        this.mapper = new ObjectMapper();
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Competitor readCompetitorFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("competitor.json");
        if (inputStream == null) {
            throw new IOException("Cannot find 'competitor.json' file in resources.");
        }
        return mapper.readValue(inputStream, Competitor.class);
    }

    public List<Competitor> scanAndDeserializeCompetitors(String directoryPath) throws IOException {
        List<Competitor> competitors = new ArrayList<>();
        List<File> files = Files.list(Path.of(directoryPath))
                .filter(path -> path.toString().endsWith(".json"))
                .map(Path::toFile)
                .collect(Collectors.toList());

        for (File file : files) {
            // Adjust to read a list of competitors from each file
            List<Competitor> fileCompetitors = mapper.readValue(file, new TypeReference<List<Competitor>>() {});
            competitors.addAll(fileCompetitors);
        }

        return competitors;
    }
}
