package com.gym.web.webappsv.repository;

import com.gym.web.webappsv.model.PersonalTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainerRepository extends JpaRepository<PersonalTrainer, Long> {
    PersonalTrainer findOneById(Long id);

}
