package com.gym.web.webappsv.service.impl;

import com.gym.web.webappsv.converter.ClassMapper;
import com.gym.web.webappsv.exception.BadRequestException;
import com.gym.web.webappsv.exception.ResourceNotFoundException;
import com.gym.web.webappsv.model.Class;
import com.gym.web.webappsv.model.Course;
import com.gym.web.webappsv.model.PersonalTrainer;
import com.gym.web.webappsv.payload.ClassRequest;
import com.gym.web.webappsv.payload.ClassResponse;
import com.gym.web.webappsv.payload.PagedResponse;
import com.gym.web.webappsv.repository.ClassRepository;
import com.gym.web.webappsv.repository.CourseRepository;
import com.gym.web.webappsv.repository.PersonalTrainerRepository;
import com.gym.web.webappsv.service.IClassService;
import com.gym.web.webappsv.utils.AppConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClassService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private PersonalTrainerRepository personalTrainerRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ClassMapper converter;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<ClassResponse> findAll() {
        List<ClassResponse> result = new ArrayList<>();
        List<Class> entities = classRepository.findAll();
        for(Class item:entities) {
            ClassResponse classResponse = modelMapper.map(item, ClassResponse.class);
            result.add(classResponse);
        }
        return  result;
    }

    @Override
    public PagedResponse<ClassResponse> getAllClasses(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Class> classes = classRepository.findAll(pageable);
        if(classes.getTotalElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), classes.getNumber(),
                    classes.getSize(), classes.getTotalElements(), classes.getTotalPages(), classes.isLast());
        }
        List<ClassResponse> classResponses = classes.map(classA -> {
            return modelMapper.map(classA, ClassResponse.class);
        }).getContent();
        return new PagedResponse<>(classResponses, classes.getNumber(),
                classes.getSize(), classes.getTotalElements(), classes.getTotalPages(), classes.isLast());
    }
    @Override
    public Class create(ClassRequest req) {
        PersonalTrainer personalTrainer = (personalTrainerRepository.findById(req.getPersonalTrainerId())).get();
        Course course = courseRepository.findById(req.getCourseId()).get();
        Class aClass = Class.builder()
                .openDate(req.getOpenDate())
                .closeDate(req.getCloseDate())
                .startDate(req.getStartDate())
                .maxStudent(req.getMaxStudent())
                .personalTrainer(personalTrainer)
                .course(course)
                .build();
        return classRepository.save(aClass);
    }

    @Override
    public ClassResponse update(ClassRequest req, Long classId) {
        Class aClass = classRepository.findById(classId).orElseThrow(
                () -> new ResourceNotFoundException("Class", "id", classId));
        Course course = courseRepository.findById(req.getCourseId()).get();
        PersonalTrainer personalTrainer = personalTrainerRepository.findById(req.getPersonalTrainerId()).get();
        aClass.setOpenDate(req.getOpenDate());
        aClass.setCloseDate(req.getCloseDate());
        aClass.setStartDate(req.getStartDate());
        aClass.setMaxStudent(req.getMaxStudent());
        aClass.setPersonalTrainer(personalTrainer);
        aClass.setCourse(course);
        classRepository.save(aClass);
        return modelMapper.map(aClass, ClassResponse.class);
    }


    @Override
    public void delete(long[] ids) {
        for(long item:ids){
            classRepository.deleteById(item);
        }
    }

    @Override
    public void deleteById(long id) {
        classRepository.deleteById(id);
    }
}
