package com.gym.web.webappsv.service.impl;

import com.gym.web.webappsv.exception.ResourceNotFoundException;
import com.gym.web.webappsv.model.Course;
import com.gym.web.webappsv.model.CourseType;
import com.gym.web.webappsv.payload.ApiResponse;
import com.gym.web.webappsv.payload.CourseRequest;
import com.gym.web.webappsv.repository.CourseRepository;
import com.gym.web.webappsv.repository.CourseTypeRepository;
import com.gym.web.webappsv.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService implements ICourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CourseTypeRepository courseTypeRepository;
    @Override
    public ResponseEntity<Course> create(CourseRequest req) {
        CourseType courseType = courseTypeRepository.findById(req.getCourseTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("CourseType", "id", req.getCourseTypeId()));
        Course course = Course.builder()
                .name(req.getName())
                .duration(req.getDuration())
                .status(req.getStatus())
                .price(req.getPrice())
                .courseType(courseType)
                .build();
        courseRepository.save(course);
        return new ResponseEntity<Course>(course, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Course> update(CourseRequest req, Long id) {
        Course course = courseRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Course","id", id));
        CourseType courseType = courseTypeRepository.findById(req.getCourseTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("CourseType", "courseTypeId", req.getCourseTypeId()));
        course.setName(req.getName());
        course.setStatus(req.getStatus());
        course.setDuration(req.getDuration());
        course.setPrice(req.getPrice());
        course.setCourseType(courseType);
        courseRepository.save(course);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        courseRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted album"), HttpStatus.OK);
    }
}
