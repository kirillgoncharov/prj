package com.netcracker.devcourses.sd4.service.services.impl;

import com.netcracker.devcourses.sd4.persistence.api.dao.FlightRepository;
import com.netcracker.devcourses.sd4.persistence.domain.Flight;
import com.netcracker.devcourses.sd4.service.dto.FlightDTO;
import com.netcracker.devcourses.sd4.service.exceptions.ResourceNotFoundException;
import com.netcracker.devcourses.sd4.service.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin on 02.11.16.
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;
    private ConversionService conversionService;

    private static final TypeDescriptor flightDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Flight.class));
    private static final TypeDescriptor flightDTODescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FlightDTO.class));

    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Value("${controllers.country.errors.notfound}")
    private String NOT_FOUND;

    @Override
    public List<FlightDTO> getAllFlights() {
        return (List<FlightDTO>) conversionService.convert(flightRepository.findAll(), flightDescriptor, flightDTODescriptor);
    }

    @Override
    public List<FlightDTO> getFilteredFlights(Integer pageNumber, Integer pageSize, String sortField, String sortOrder) {
        int page = pageNumber != null ? pageNumber : 0;
        int size = pageSize != null ? pageSize : 10;
        Sort.Direction direction = "DESC".equalsIgnoreCase(sortOrder) ? Sort.Direction.DESC : Sort.Direction.ASC;
        List<Flight> filteredFlights = flightRepository.findAll(new PageRequest(page, size, direction, sortField)).getContent();
        if (CollectionUtils.isEmpty(filteredFlights)) {
            throw new ResourceNotFoundException(NOT_FOUND);
        }
        return (List<FlightDTO>) conversionService.convert(filteredFlights, flightDescriptor, flightDTODescriptor);
    }

    @Override
    public List<FlightDTO> getAllFlightsForAirport(String airportName) {
        List<Flight> flights = new ArrayList<>();
        flights.addAll(flightRepository.findByArrivalAirportName(airportName));
        flights.addAll(flightRepository.findByDepartureAirportName(airportName));
        if (CollectionUtils.isEmpty(flights)) {
            throw new ResourceNotFoundException(NOT_FOUND);
        }
        return (List<FlightDTO>) conversionService.convert(flights, flightDescriptor, flightDTODescriptor);
    }
}
