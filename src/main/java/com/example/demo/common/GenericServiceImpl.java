package com.example.demo.common;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericServiceImpl<T, ID extends Serializable> implements IGenericService<T, ID> {

    @Override
    public T save(T entity) {
        // TODO Auto-generated method stub
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        // TODO Auto-generated method stub
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        // TODO Auto-generated method stub
        Optional<T> obj = getDao().findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        // TODO Auto-generated method stub
        return getDao().findAll();
    }

    public abstract JpaRepository<T, ID> getDao();

}
