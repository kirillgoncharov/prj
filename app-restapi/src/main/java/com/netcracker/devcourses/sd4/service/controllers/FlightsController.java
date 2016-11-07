package com.netcracker.devcourses.sd4.service.controllers;

import com.netcracker.devcourses.sd4.persistence.api.dao.FlightRepository;
import com.netcracker.devcourses.sd4.persistence.domain.Flight;
import com.netcracker.devcourses.sd4.service.dto.FlightDTO;
import com.netcracker.devcourses.sd4.service.services.FlightService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Konstantin on 02.11.16.
 */
@RestController
@RequestMapping("/flights")
public class FlightsController {

    private FlightService flightService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightDTO> getFlights(
            @RequestParam(required = false) final Integer pageNumber,
            @RequestParam(required = false) final Integer pageSize,
            @RequestParam(required = false) final String sortField,
            @RequestParam(required = false) final String sortOrder) {
        if (pageNumber != null && pageSize != null && sortField != null && sortOrder != null) {
            return flightService.getFilteredFlights(pageNumber, pageSize, sortField, sortOrder);
        }
        return flightService.getAllFlights();
    }

    @RequestMapping(value = "/{airportName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightDTO> getFlightsByAirportName(@PathVariable String airportName) {
        return flightService.getAllFlightsForAirport(airportName);
    }
}
