package com.gym.web.webappsv.converter;

import com.gym.web.webappsv.DTO.ClassDTO;
import com.gym.web.webappsv.model.Class;
import com.gym.web.webappsv.payload.ClassResponse;
import org.springframework.stereotype.Component;

@Component
public class ClassMapper {
    public Class toEntity(ClassResponse res){
        Class aClass = new Class();
        aClass.setOpenDate(res.getOpenDate());
        aClass.setCloseDate(res.getCloseDate());
        aClass.setStartDate(res.getStartDate());
        aClass.setMaxStudent(res.getMaxStudent());
        return aClass;
    }
    public  ClassDTO toDTO(Class aClass) {
        ClassDTO classDTO = new ClassDTO();
        if (aClass.getId() != null) {
            classDTO.setId(aClass.getId());
        }
        classDTO.setOpenDate(aClass.getOpenDate());
        classDTO.setCloseDate(aClass.getCloseDate());
        classDTO.setStartDate(aClass.getStartDate());
        classDTO.setMaxStudent(aClass.getMaxStudent());
        classDTO.setPersonalTrainerId(aClass.getPersonalTrainer().getId());
        return classDTO;
    }

    public Class toEntity(ClassDTO dto, Class enity) {
        enity.setOpenDate(dto.getOpenDate());
        enity.setCloseDate(dto.getCloseDate());
        enity.setStartDate(dto.getStartDate());
        enity.setMaxStudent(dto.getMaxStudent());
        return enity;
    }
}
