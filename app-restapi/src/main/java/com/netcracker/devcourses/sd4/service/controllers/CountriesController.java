package com.netcracker.devcourses.sd4.service.controllers;

import com.netcracker.devcourses.sd4.service.dto.CountryDTO;
import com.netcracker.devcourses.sd4.service.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Konstantin on 30.10.16.
 */
@RestController
@RequestMapping("/countries")
public class CountriesController {

    private CountryService countryService;

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryDTO> getCountries() {
        return countryService.getCountries();
    }

    @RequestMapping(value = "/{countryName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryDTO getCountryByName(@PathVariable String countryName) {
        return countryService.getCountryByName(countryName);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CountryDTO createCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.createCountry(countryDTO);
    }

    @RequestMapping(value = "/{countryName}", method = RequestMethod.PUT)
    public CountryDTO updateCountry(@PathVariable String countryName, @RequestBody CountryDTO countryDTO) {
        return countryService.updateCountry(countryName, countryDTO);
    }

    @RequestMapping(value = "/{countryName}", method = RequestMethod.DELETE)
    public void deleteCountry(@PathVariable String countryName) {
        countryService.deleteCountry(countryName);
    }
}