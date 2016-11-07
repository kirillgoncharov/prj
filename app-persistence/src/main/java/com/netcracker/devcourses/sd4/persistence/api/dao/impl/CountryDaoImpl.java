package com.netcracker.devcourses.sd4.persistence.api.dao.impl;

import com.netcracker.devcourses.sd4.persistence.api.dao.CountryDao;
import com.netcracker.devcourses.sd4.persistence.domain.Country;
import com.netcracker.devcourses.sd4.persistence.domain.Country_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Konstantin on 23.10.16.
 */
@Repository
public class CountryDaoImpl extends AbstractDao implements CountryDao {

    @Override
    public Country getCountry(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> cq = cb.createQuery(Country.class);
        Root<Country> from = cq.from(Country.class);
        cq.where(cb.equal(from.get(Country_.name), name));
        cq.select(from);
        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public void addCountry(Country country) {
        entityManager.persist(country);
    }

    @Override
    public void updateCountry(Country country) {
        entityManager.merge(country);
    }

    @Override
    public void deleteCountry(Country country) {
        entityManager.remove(country);
    }
}
