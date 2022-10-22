package com.gym.web.webappsv.service.impl;

import com.gym.web.webappsv.exception.BadRequestException;
import com.gym.web.webappsv.exception.ResourceNotFoundException;
import com.gym.web.webappsv.model.CourseType;
import com.gym.web.webappsv.payload.CourseTypeRequest;
import com.gym.web.webappsv.payload.CourseTypeResponse;
import com.gym.web.webappsv.payload.PagedResponse;
import com.gym.web.webappsv.repository.CourseRepository;
import com.gym.web.webappsv.repository.CourseTypeRepository;
import com.gym.web.webappsv.service.ICourseTypeService;
import com.gym.web.webappsv.utils.AppConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CourseTypeService implements ICourseTypeService {
    @Autowired
    CourseTypeRepository courseTypeRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public PagedResponse<CourseTypeResponse> getAllCouseType(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }
        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<CourseType> courseTypes =  courseTypeRepository.findAll(pageable);
        if(courseTypes.getTotalElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), courseTypes.getNumber(), courseTypes.getSize(),
                    courseTypes.getTotalElements(), courseTypes.getTotalPages(), courseTypes.isLast());
        }
        List<CourseTypeResponse> courseTypeResponses = courseTypes.map(courseType -> {
            return modelMapper.map(courseType, CourseTypeResponse.class);
        }).getContent();
        return new PagedResponse<>(courseTypeResponses, courseTypes.getNumber(), courseTypes.getSize(),
                courseTypes.getTotalElements(), courseTypes.getTotalPages(), courseTypes.isLast());
    }

    @Override
    public CourseType create(CourseTypeRequest courseTypeRequest) {
        CourseType courseType = CourseType.builder()
                .name(courseTypeRequest.getName())
                .describer(courseTypeRequest.getDescriber())
                .build();
        return courseTypeRepository.save(courseType);
    }

    @Override
    public CourseTypeResponse updateCourseType(CourseTypeRequest courseTypeRequest, Long id) {
        CourseType courseType = courseTypeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course", "id", id));
        courseType.setCourses(courseTypeRequest.getCourses());
        courseType.setName(courseTypeRequest.getName());
        courseType.setDescriber(courseType.getDescriber());
        courseTypeRepository.save(courseType);
        return modelMapper.map(courseType, CourseTypeResponse.class);
    }

    @Override
    public void deleteById(Long id) {
        courseTypeRepository.deleteById(id);
    }
}
