package com.gym.web.webappsv.service;

import com.gym.web.webappsv.model.CourseType;
import com.gym.web.webappsv.payload.CourseTypeRequest;
import com.gym.web.webappsv.payload.CourseTypeResponse;
import com.gym.web.webappsv.payload.PagedResponse;

public interface ICourseTypeService {
    PagedResponse<CourseTypeResponse> getAllCouseType(int page, int size);
    CourseType create(CourseTypeRequest courseTypeRequest);
    CourseTypeResponse updateCourseType(CourseTypeRequest courseTypeRequest, Long id);
    void deleteById(Long id);
}
