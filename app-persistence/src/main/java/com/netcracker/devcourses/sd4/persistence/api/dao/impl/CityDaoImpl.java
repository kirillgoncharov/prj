package com.netcracker.devcourses.sd4.persistence.api.dao.impl;

import com.netcracker.devcourses.sd4.persistence.api.dao.CityDao;
import com.netcracker.devcourses.sd4.persistence.domain.City;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Konstantin on 24.10.16.
 */
@Repository
public class CityDaoImpl extends AbstractDao implements CityDao {

    @Override
    public City getCity(String name) {
        TypedQuery<City> query = entityManager.createNamedQuery("getCityByName", City.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public City getCityByAirportName(String airportName) {
        TypedQuery<City> query = entityManager.createNamedQuery("getCityByAirportName", City.class);
        query.setParameter("name", airportName);
        return query.getSingleResult();
    }

    @Override
    public void addCity(City city) {
        entityManager.persist(city);
    }

    @Override
    public void updateCity(City city) {
        entityManager.merge(city);
    }

    @Override
    public void deleteCity(City city) {
        entityManager.remove(city);
    }

    @Override
    public <T> List<T> getAllEntities(Class<T> clazz) {
        TypedQuery<T> query = entityManager.createNamedQuery("getAllCities", clazz);
        return query.getResultList();
    }
}
