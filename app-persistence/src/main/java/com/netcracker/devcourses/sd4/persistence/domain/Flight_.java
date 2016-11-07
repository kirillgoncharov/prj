package com.netcracker.devcourses.sd4.persistence.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Flight.class)
public abstract class Flight_ {

	public static volatile SingularAttribute<Flight, LocalDate> departureTime;
	public static volatile SingularAttribute<Flight, Airport> departureAirport;
	public static volatile SingularAttribute<Flight, LocalDate> arrivalTime;
	public static volatile SingularAttribute<Flight, Integer> id;
	public static volatile SingularAttribute<Flight, Airport> arrivalAirport;

}

