package com.gym.web.webappsv.service;

import com.gym.web.webappsv.model.Course;
import com.gym.web.webappsv.payload.ApiResponse;
import com.gym.web.webappsv.payload.CourseRequest;
import com.gym.web.webappsv.payload.PagedResponse;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ICourseService {
    ResponseEntity<Course> create(CourseRequest courseRequest);
    ResponseEntity<?> update(CourseRequest courseRequest, Long id);
    ResponseEntity<ApiResponse> deleteById(Long id);
}
