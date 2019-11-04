package pl.karolmalysa.csvreader.persistance;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import pl.karolmalysa.csvreader.domain.PersonalData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static pl.karolmalysa.csvreader.repository.CSVReader.records;

@Repository
public class CustomerRepo {

    @PersistenceContext
    private EntityManager em;

    public static List<PersonalData> customersList = new ArrayList<>();

//    @Transactional
    public static void createCustomers(){

        for(int i=0; i<records.size(); i++){
            customersList.add(new PersonalData(records.get(i).get(0), records.get(i).get(1), parseInt(0+records.get(i).get(2)), records.get(i).get(3)));
//            em.persist(new PersonalData(records.get(i).get(0), records.get(i).get(1), parseInt(0+records.get(i).get(2)), records.get(i).get(3)));

         }

        System.out.println(customersList);
    }



}
