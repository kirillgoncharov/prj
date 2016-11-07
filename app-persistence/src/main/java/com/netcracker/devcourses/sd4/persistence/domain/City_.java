package com.netcracker.devcourses.sd4.persistence.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(City.class)
public abstract class City_ {

	public static volatile SingularAttribute<City, Country> country;
	public static volatile SingularAttribute<City, String> name;
	public static volatile SingularAttribute<City, Integer> id;
	public static volatile SetAttribute<City, Airport> airports;

}

