package com.gym.web.webappsv.repository;

import com.gym.web.webappsv.model.Subscribe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscribeRepository extends CrudRepository<Subscribe, Long> {
}
