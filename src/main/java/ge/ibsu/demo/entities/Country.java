package ge.ibsu.demo.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id", length = 2)
    private String id;

    @Column(name = "country_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    public Country() {
    }

    public Country(String id, String name, Region region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Region getRegion() {
        return region;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}