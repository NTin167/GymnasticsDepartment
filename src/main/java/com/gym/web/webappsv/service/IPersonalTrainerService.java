package com.gym.web.webappsv.service;

import com.gym.web.webappsv.DTO.PersonalTrainerDTO;
import com.gym.web.webappsv.Response.PersonalTrainerResponse;

import java.util.List;

public interface IPersonalTrainerService {
    List<PersonalTrainerDTO> findAll();
    PersonalTrainerDTO save(PersonalTrainerDTO personalTrainerDTO);
    void delete(long [] ids);
    PersonalTrainerResponse getAllPT(int pageNo, int pageSize, String sortBy, String sortDir);
}
