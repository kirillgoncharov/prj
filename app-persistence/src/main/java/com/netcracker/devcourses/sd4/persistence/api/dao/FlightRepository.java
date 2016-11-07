package com.netcracker.devcourses.sd4.persistence.api.dao;

import com.netcracker.devcourses.sd4.persistence.domain.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.Date;
import java.util.List;

/**
 * Created by Konstantin on 25.10.16.
 */
@RepositoryDefinition(domainClass = Flight.class, idClass = Integer.class)
public interface FlightRepository {
    List<Flight> findAll();
    Page<Flight> findAll(Pageable pageable);
    List<Flight> findByArrivalTimeBetween(Date from, Date to);
    List<Flight> findByArrivalAirportName(String airportName);
    List<Flight> findByDepartureAirportName(String airportName);
    Flight save(Flight flight);
}
