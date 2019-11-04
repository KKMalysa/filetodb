package pl.karolmalysa.csvreader.domain;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "AGE")

    private int age;

    @Transient  //ponieważ wg polecenia to pole nie występuje w bazie danych
    private  String city;

    public PersonalData(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public PersonalData() {

    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "id="+ id +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
