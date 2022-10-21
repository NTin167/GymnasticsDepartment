package com.gym.web.webappsv.repository;

import com.gym.web.webappsv.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Class findOneById(Long id);
}
