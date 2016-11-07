package com.netcracker.devcourses.sd4.service.converters;

import com.netcracker.devcourses.sd4.persistence.domain.Country;
import com.netcracker.devcourses.sd4.service.dto.CountryDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Konstantin on 01.11.16.
 */
public class CountryDTOToCountryConverter implements Converter<CountryDTO, Country> {
    @Override
    public Country convert(CountryDTO countryDTO) {
        Country country = new Country(countryDTO.getName());
        return country;
    }
}
