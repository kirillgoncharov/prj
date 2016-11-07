package com.netcracker.devcourses.sd4.service.converters;

import com.netcracker.devcourses.sd4.persistence.domain.Flight;
import com.netcracker.devcourses.sd4.service.dto.FlightDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Konstantin on 02.11.16.
 */
public class FlightToFlightDTOConverter implements Converter<Flight, FlightDTO> {
    @Override
    public FlightDTO convert(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setArrivalAirport(flight.getArrivalAirport().getName());
        dto.setDepartureAirport(flight.getDepartureAirport().getName());
        dto.setArrivalTime(flight.getArrivalTime().toString());
        dto.setDepartureTime(flight.getDepartureTime().toString());

        return dto;
    }
}
