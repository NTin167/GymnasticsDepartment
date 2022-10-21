package com.gym.web.webappsv.service.impl;

import com.gym.web.webappsv.DTO.PersonalTrainerDTO;
import com.gym.web.webappsv.Response.PersonalTrainerResponse;
import com.gym.web.webappsv.converter.PersonalTrainerMapper;
import com.gym.web.webappsv.model.PersonalTrainer;
import com.gym.web.webappsv.repository.PersonalTrainerRepository;
import com.gym.web.webappsv.service.IPersonalTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalTrainerService implements IPersonalTrainerService {

    @Autowired
    PersonalTrainerRepository personalTrainerRepository;

    @Autowired
    PersonalTrainerMapper converter = new PersonalTrainerMapper();
    @Override
    public List<PersonalTrainerDTO> findAll() {
//        CASE3:

        List<PersonalTrainer> personalTrainer = personalTrainerRepository.findAll();
        List<PersonalTrainerDTO> personalTrainerDTOS = new ArrayList<>();
        for(PersonalTrainer items:personalTrainer){
            PersonalTrainerDTO personalTrainerDTO = converter.convertToDto(items);
            personalTrainerDTOS.add(personalTrainerDTO);
        }
        return personalTrainerDTOS;
        //CASE2
//        return personalTrainerRepository.findAll().stream().map(personalTrainer->PersonalTrainerMapper.getInstance().convertToDto(personalTrainer)).collect(Collectors.toList());
    }

    @Override
    public PersonalTrainerDTO save(PersonalTrainerDTO personalTrainerDTO) {
        PersonalTrainer entity = new PersonalTrainer();
        if(personalTrainerDTO.getId() != null){
            PersonalTrainer oldPersonalTrainer = personalTrainerRepository.findOneById(personalTrainerDTO.getId());
            entity = converter.convertToEntity(personalTrainerDTO, oldPersonalTrainer);
        }
        else {
            entity = converter.convertToEntity(personalTrainerDTO);
        }
        entity = personalTrainerRepository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item:ids){
            personalTrainerRepository.deleteById(item);
        }
    }

    @Override
    public PersonalTrainerResponse getAllPT(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<PersonalTrainer> personalTrainers = personalTrainerRepository.findAll(pageable);
        List<PersonalTrainer> listOfPersonalTrainer = personalTrainers.getContent();
        List<PersonalTrainerDTO> content = personalTrainers.stream().map(personalTrainer -> converter.convertToDto(personalTrainer)).collect(Collectors.toList());
        PersonalTrainerResponse response = new PersonalTrainerResponse();
        response.setContent(content);
        response.setPageNo(personalTrainers.getNumber());
        response.setPageSize(personalTrainers.getSize());
        response.setTotalElements(personalTrainers.getTotalElements());
        response.setTotalPages(personalTrainers.getTotalPages());
        response.setLast(personalTrainers.isLast());

        return response;
    }
}
