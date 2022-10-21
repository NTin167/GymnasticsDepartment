package com.gym.web.webappsv.service;

public interface CrudService<T, ID> {
    T findByName(String name);
}
