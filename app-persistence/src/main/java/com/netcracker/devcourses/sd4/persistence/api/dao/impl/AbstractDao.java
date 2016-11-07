package com.netcracker.devcourses.sd4.persistence.api.dao.impl;

import com.netcracker.devcourses.sd4.persistence.api.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Konstantin on 23.10.16.
 */
public abstract class AbstractDao implements BaseDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public <T> List<T> getAllEntities(Class<T> clazz) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<? extends T> from = cq.from(clazz);
        cq.select(from);
        TypedQuery<T> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public <T> T getEntity(Class<T> clazz, Object id) {
        return entityManager.find(clazz, id);
    }
}
