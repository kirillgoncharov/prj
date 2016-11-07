package com.netcracker.devcourses.sd4.service.services;

import com.netcracker.devcourses.sd4.service.dto.FlightDTO;

import java.util.List;

/**
 * Created by Konstantin on 02.11.16.
 */
public interface FlightService {
    List<FlightDTO> getAllFlights();
    List<FlightDTO> getFilteredFlights(Integer pageNumber, Integer pageSize, String sortField, String sortOrder);
    List<FlightDTO> getAllFlightsForAirport(String airportName);
}
