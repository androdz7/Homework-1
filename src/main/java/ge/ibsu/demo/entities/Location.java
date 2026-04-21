package ge.ibsu.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", columnDefinition = "varchar(2)")
    private Country country;

    public Location(){
    }

    public Location(Long id, String streetAddress, String city, Country country) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}