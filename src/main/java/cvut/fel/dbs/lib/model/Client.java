package cvut.fel.dbs.lib.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "idClient")
    private int clientID;

    @Column(name = "rodnicislo")
    private int rodnicislo;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @ManyToMany(mappedBy = "fanClients")
    private Collection<Reality> realities;

    public Client(int rodnicislo, String firstName, String lastName, String email, int phone){
        this.rodnicislo = rodnicislo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Client() {

    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getRodnicislo() {
        return rodnicislo;
    }

    public void setRodnicislo(int rodnicislo) {
        this.rodnicislo = rodnicislo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Collection<Reality> getRealities() {
        return realities;
    }


    @Override
    public String toString() {
        return "----------  clientID=" + clientID +
                ", rodnicislo=" + rodnicislo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone + "\n";

    }
    public String toString2() {
        return "  clientID=" + clientID +
                ", rodnicislo=" + rodnicislo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone + "\n";

    }
}
