package oop.lab.users.dao;

import java.io.Serializable;

interface BaseDAO<T, ID extends Serializable> {

    <S extends T> S save(S entity);

    T findOne(ID primaryKey);

    Iterable<T> findAll();

    Long count();

    void delete(T entity);

    boolean exists(ID primaryKey);


}