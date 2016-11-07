package com.netcracker.devcourses.sd4.persistence.api.dao;

import java.util.List;

/**
 * Created by Konstantin on 24.10.16.
 */
public interface BaseDao {
    <T> List<T> getAllEntities(Class<T> clazz);

    <T> T getEntity(Class<T> clazz, Object id);
}
