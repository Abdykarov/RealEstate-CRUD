package cvut.fel.dbs.lib.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Reality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idObject")
    private int idObject;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "psc")
    private int psc;

    @Column(name = "objectType")
    private String objectType;

    @Column(name = "price")
    private int price;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "favourites",
            joinColumns = @JoinColumn(name="idObject"),
            inverseJoinColumns = @JoinColumn(name = "idClient"))
    private Collection<Client> fanClients;


    public Reality(String street, String city, int psc, String objectType, int price){
        this.street = street;
        this.city = city;
        this.price = price;
        this.objectType = objectType;
        this.psc = psc;
    }

    @Override
    public String toString() {
        return "   idObject=" + idObject +
                "\n     --------- city='" + city + '\'' +
                "\n     --------- street='" + street + '\'' +
                "\n     --------- psc=" + psc +
                "\n     --------- objectType='" + objectType + '\'' +
                "\n     --------- price=" + price +
                "\n";
    }
    public String toString3() {
        return " idObject=" + idObject +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", psc=" + psc +
                ", objectType='" + objectType + '\'' +
                ",price=" + price +
                "\n";
    }
    public String toString2() {
        return " ----- idObject=" + idObject +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", psc=" + psc +
                ", objectType='" + objectType + '\'' +
                ",price=" + price +
                "\n";
    }

    public Reality() {

    }

    public int getIdObject() {
        return idObject;
    }

    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPsc() {
        return psc;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Collection<Client> getFanClients() {
        return fanClients;
    }

    public void setFanClients(Collection<Client> fanClients) {
        this.fanClients = fanClients;
    }
}
