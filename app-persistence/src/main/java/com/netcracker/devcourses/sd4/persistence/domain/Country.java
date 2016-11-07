package com.netcracker.devcourses.sd4.persistence.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Konstantin on 21.10.16.
 */
@Entity
@Table(name = "Country")
public class Country {

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<City> cities;

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
