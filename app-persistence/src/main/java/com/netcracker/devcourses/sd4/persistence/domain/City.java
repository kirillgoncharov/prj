package com.netcracker.devcourses.sd4.persistence.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Konstantin on 21.10.16.
 */
@Entity
@Table(name = "City")
@NamedQueries({
        @NamedQuery(name = "getCityByName", query = "select c from City c where c.name = :name"),
        @NamedQuery(name = "getAllCities", query = "select c from City c"),
        @NamedQuery(name = "getCityByAirportName", query = "select c from City c inner join c.airports a where a.name = :name")
})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Airport> airports;

    public Set<Airport> getAirports() {
        return airports;
    }

    public void setAirports(Set<Airport> airports) {
        this.airports = airports;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
