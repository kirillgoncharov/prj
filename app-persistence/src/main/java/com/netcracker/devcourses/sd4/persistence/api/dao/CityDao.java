package com.netcracker.devcourses.sd4.persistence.api.dao;

import com.netcracker.devcourses.sd4.persistence.domain.City;

/**
 * Created by Konstantin on 24.10.16.
 */
public interface CityDao extends BaseDao {
    City getCity(String name);
    City getCityByAirportName(String airportName);
    void addCity(City city);
    void updateCity(City city);
    void deleteCity(City city);
}
