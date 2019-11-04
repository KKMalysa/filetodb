package pl.karolmalysa.csvreader.domain;

import javax.persistence.*;

@Entity
@Table(name = "CONTACTS")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @ManyToOne
    private PersonalData CUSTOMER;
    @Column(name = "CONTACT")
    private String contact;



    private void setCustomer(PersonalData CUSTOMER){
        this.CUSTOMER =CUSTOMER;
    }

    public Contacts(String contact) {
        this.contact = contact;
    }

    public Contacts() {
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                '}';
    }

}
