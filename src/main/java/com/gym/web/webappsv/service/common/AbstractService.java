package com.gym.web.webappsv.service.common;

import com.gym.web.webappsv.service.IOperations;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {
    @Override
    @Transactional(readOnly = true)
    public T findById(long id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public Page<T> findPaginated(int page, int size) {
        return null;
    }

    @Override
    public T create(T entity) {
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
