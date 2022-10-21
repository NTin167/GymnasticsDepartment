package com.gym.web.webappsv.controller;

import com.gym.web.webappsv.model.CourseType;
import com.gym.web.webappsv.payload.ApiResponse;
import com.gym.web.webappsv.payload.CourseTypeRequest;
import com.gym.web.webappsv.payload.CourseTypeResponse;
import com.gym.web.webappsv.payload.PagedResponse;
import com.gym.web.webappsv.service.impl.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.Phaser;

@RestController
@RequestMapping("/coursetype")
public class CourseTypeController {
    @Autowired
    CourseTypeService courseTypeService;

    @GetMapping("/{page}/{size}")
    public PagedResponse<CourseTypeResponse> getPagination(@PathVariable(value = "page") int page,
                                                           @PathVariable(value = "size") int size) {
        return courseTypeService.getAllCouseType(page, size);
    }
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> creatCourseType(@Valid @RequestBody CourseTypeRequest courseTypeRequest) {
        courseTypeService.create(courseTypeRequest);
        return ResponseEntity.ok()
                .body(new ApiResponse(true, "Course Type created succesfully"));
    }
    @PutMapping(value = "{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CourseTypeResponse updateCourseType(@RequestBody CourseTypeRequest request,
                                                               @PathVariable("id") long id) {
        return courseTypeService.updateCourseType(request, id);
    }
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCourseType(@PathVariable("id") long id) {
        courseTypeService.deleteById(id);
    }
}
