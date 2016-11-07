package com.netcracker.devcourses.sd4.persistence.api.dao;

import com.netcracker.devcourses.sd4.persistence.domain.Airport;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Konstantin on 25.10.16.
 */
public interface AirportRepository extends CrudRepository<Airport, Integer> {
}
