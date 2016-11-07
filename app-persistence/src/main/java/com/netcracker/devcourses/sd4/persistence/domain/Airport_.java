package com.netcracker.devcourses.sd4.persistence.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Airport.class)
public abstract class Airport_ {

	public static volatile SetAttribute<Airport, Flight> arrivalFlights;
	public static volatile SetAttribute<Airport, Flight> departureFlights;
	public static volatile SingularAttribute<Airport, City> city;
	public static volatile SingularAttribute<Airport, String> name;
	public static volatile SingularAttribute<Airport, Integer> id;

}

