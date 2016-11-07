package com.netcracker.devcourses.sd4.persistence.api.dao;

import com.netcracker.devcourses.sd4.persistence.domain.Country;

/**
 * Created by Konstantin on 23.10.16.
 */
public interface CountryDao extends BaseDao {
    Country getCountry(String name);
    void addCountry(Country country);
    void updateCountry(Country country);
    void deleteCountry(Country country);
}
