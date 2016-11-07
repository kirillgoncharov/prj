package com.netcracker.devcourses.sd4.service.configuration;

import com.netcracker.devcourses.sd4.persistence.configuration.PersistenceConfiguration;
import com.netcracker.devcourses.sd4.service.converters.CountryDTOToCountryConverter;
import com.netcracker.devcourses.sd4.service.converters.CountryToCountryDTOConverter;
import com.netcracker.devcourses.sd4.service.converters.FlightToFlightDTOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Konstantin on 29.10.16.
 */
@Configuration
@EnableWebMvc
@PropertySource("classpath:messages.properties")
@Import(PersistenceConfiguration.class)
public class RestApiConfiguration {

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(getConverters());
        return conversionServiceFactoryBean;
    }

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new CountryToCountryDTOConverter());
        converters.add(new CountryDTOToCountryConverter());
        converters.add(new FlightToFlightDTOConverter());

        return converters;
    }
}
