package com.appitem.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface IRepository<T, Integer> {
    public List<T> getAll();
    public T save(T entity);
    public T update(T entity);
    public void delete(int id);
    public T get(int id);
    public void deleteAll();
}
