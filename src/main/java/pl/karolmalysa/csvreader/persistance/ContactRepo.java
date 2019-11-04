package pl.karolmalysa.csvreader.persistance;

import pl.karolmalysa.csvreader.domain.Contacts;

import java.util.ArrayList;
import java.util.List;

import static pl.karolmalysa.csvreader.repository.CSVReader.records;


public class ContactRepo {
    public static List<Contacts> contactsList = new ArrayList<>();

    public static void createContact(){

        for(int i=0; i<records.size(); i++){

            for (int j = 4; j< records.get(i).size(); j++) {
                contactsList.add(new Contacts(records.get(i).get(j)));
            }

        }
        System.out.println();
        System.out.println(contactsList);
        System.out.println();
    }

}
