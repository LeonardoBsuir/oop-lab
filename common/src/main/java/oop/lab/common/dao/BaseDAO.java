package oop.lab.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T, ID extends Serializable> {

    <S extends T> S save(S entity);

    T findOne(ID primaryKey);

    List<T> findAll();

    Long count();

    void delete(T entity);

    boolean exists(ID primaryKey);


}