package com.netcracker.devcourses.sd4.service.services.impl;

import com.netcracker.devcourses.sd4.persistence.api.dao.CountryDao;
import com.netcracker.devcourses.sd4.persistence.domain.Country;
import com.netcracker.devcourses.sd4.service.dto.CountryDTO;
import com.netcracker.devcourses.sd4.service.exceptions.ResourceNotFoundException;
import com.netcracker.devcourses.sd4.service.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Konstantin on 02.11.16.
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private CountryDao countryDao;
    private ConversionService conversionService;

    private static final TypeDescriptor countryDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Country.class));
    private static final TypeDescriptor countryDTODescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CountryDTO.class));

    @Value("${controllers.country.errors.notfound}")
    private String NOT_FOUND_MESSAGE;

    @Autowired
    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
    @Override
    public List<CountryDTO> getCountries() {
        List<Country> countries = countryDao.getAllEntities(Country.class);
        List<CountryDTO> result = (List<CountryDTO>) conversionService.convert(countries, countryDescriptor, countryDTODescriptor);
        if (CollectionUtils.isEmpty(result)) {
            throw new ResourceNotFoundException(NOT_FOUND_MESSAGE);
        }

        return result;
    }

    @Override
    public CountryDTO getCountryByName(String countryName) {
        Country country = countryDao.getCountry(countryName);
        if (country == null) {
            throw new ResourceNotFoundException(NOT_FOUND_MESSAGE);
        }
        return conversionService.convert(country, CountryDTO.class);
    }

    @Override
    public CountryDTO createCountry(CountryDTO countryDTO) {
        Country country = conversionService.convert(countryDTO, Country.class);
        countryDao.addCountry(country);
        return countryDTO;
    }

    @Override
    public CountryDTO updateCountry(String countryName, CountryDTO countryDTO) {
        Country country = countryDao.getCountry(countryName);
        if (country == null) {
            throw new ResourceNotFoundException(NOT_FOUND_MESSAGE);
        }
        country.setName(countryDTO.getName());
        countryDao.updateCountry(country);
        return countryDTO;
    }

    @Override
    public void deleteCountry(String countryName) {
        Country country = countryDao.getCountry(countryName);
        countryDao.deleteCountry(country);
    }
}
