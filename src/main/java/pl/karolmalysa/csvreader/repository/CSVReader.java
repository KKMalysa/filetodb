package pl.karolmalysa.csvreader.repository;

import org.springframework.stereotype.Repository;
import pl.karolmalysa.csvreader.persistance.ContactRepo;
import pl.karolmalysa.csvreader.persistance.CustomerRepo;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CSVReader {

    public static List<List<String>> records = new ArrayList<>();

    public static void readCSV(String filePath) throws FileNotFoundException {
        Path inputPath = Paths.get(filePath);


        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(inputPath)))){
        String line;
        while ((line = br.readLine()) != null){
            String[] values = line.split(",");
            records.add(Arrays.asList(values));
        }
    } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(records);
        CustomerRepo.createCustomers();
        ContactRepo.createContact();

    }


}
