package com.gym.web.webappsv.converter;

import com.gym.web.webappsv.DTO.PersonalTrainerDTO;
import com.gym.web.webappsv.model.PersonalTrainer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonalTrainerMapper {
    public static PersonalTrainerMapper INSTANCE;
    public static PersonalTrainerMapper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PersonalTrainerMapper();
        }
        return INSTANCE;
    }
    @Autowired
    ModelMapper modelMapper;
    public PersonalTrainerDTO convertToDto(PersonalTrainer personalTrainer){
//        CASE1
        PersonalTrainerDTO personalTrainerDTO = modelMapper.map(personalTrainer, PersonalTrainerDTO.class);
        return personalTrainerDTO;
//        CASE2:
//        Long id = personalTrainer.getId();
//        String name = personalTrainer.getName();
//        String gender = personalTrainer.getGender();
//        String address = personalTrainer.getAddress();
//        String identifyCard = personalTrainer.getIdentifyCard();
//        String dob = personalTrainer.getDob();
//        String phoneNumber = personalTrainer.getPhoneNumber();
//        return new PersonalTrainerDTO(id, name, gender, address, identifyCard, dob, phoneNumber);
    }

    public PersonalTrainer convertToEntity(PersonalTrainerDTO personalTrainerDTO)
    {
        PersonalTrainer personalTrainer = modelMapper.map(personalTrainerDTO, PersonalTrainer.class);
        return personalTrainer;
    }

    public PersonalTrainer convertToEntity(PersonalTrainerDTO personalTrainerDTO, PersonalTrainer entity) {
        entity = modelMapper.map(personalTrainerDTO, PersonalTrainer.class);
        return entity;
    }
}
