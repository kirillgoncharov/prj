package com.netcracker.devcourses.sd4.service.services;

import com.netcracker.devcourses.sd4.service.dto.CountryDTO;

import java.util.List;

/**
 * Created by Konstantin on 02.11.16.
 */
public interface CountryService {
    List<CountryDTO> getCountries();
    CountryDTO getCountryByName(String countryName);
    CountryDTO createCountry(CountryDTO countryDTO);
    CountryDTO updateCountry(String countryName, CountryDTO countryDTO);
    void deleteCountry(String countryName);
}
