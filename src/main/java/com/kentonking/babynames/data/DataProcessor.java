package com.kentonking.babynames.data;

import com.kentonking.babynames.entites.Baby;
import com.kentonking.babynames.exceptions.NoDirectoryFoundException;
import com.kentonking.babynames.repositories.BabyRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class DataProcessor {

    private final BabyRepository babyRepository;
    private static final String SHORT_DATA = "./static/us_babynames_short";
    private static final String LONG_DATA = "./static/us_babynames_long";

    @Autowired
    public DataProcessor(BabyRepository babyRepository) {
        this.babyRepository = babyRepository;
    }

    @PostConstruct
    @Transactional
    public void loadData() {
        ClassPathResource classPathResource = new ClassPathResource(LONG_DATA);
        File directory;
        File[] files;

        try {
            directory = classPathResource.getFile();
            files = directory.listFiles();
        } catch (IOException e) {
            throw new NoDirectoryFoundException("Could not find directory " + LONG_DATA + " or directory was empty.");
        }

        if (files == null) {
            throw new NoDirectoryFoundException("Could not find directory " + LONG_DATA + " or directory was empty.");
        }

        for (File file : files) {

            try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {

                Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(inputStream);
                int femaleRanking = 0;
                int maleRanking = 0;

                for (CSVRecord record : records) {
                    String year = file.getName().substring(3, 7);
                    String name = record.get(0);
                    String gender = record.get(1);
                    String totalBirths = record.get(2);
                    String tenthsPosition = year.substring(2, 3);
                    String decade = year.substring(0, 2) + tenthsPosition + "0";

                    Baby baby = new Baby();
                    baby.setBirthYear(Integer.parseInt(year));
                    baby.setGender(gender);
                    baby.setName(name);
                    baby.setTotalBirths(Integer.parseInt(totalBirths));
                    baby.setDecade(Integer.parseInt(decade));

                    if (gender.equals("F")) {
                        baby.setRanking(++femaleRanking);
                    } else {
                        baby.setRanking(++maleRanking);
                    }

                    babyRepository.save(baby);
                }

            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
