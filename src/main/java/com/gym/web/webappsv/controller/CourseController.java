package com.gym.web.webappsv.controller;

import com.gym.web.webappsv.model.Course;
import com.gym.web.webappsv.payload.ApiResponse;
import com.gym.web.webappsv.payload.CourseRequest;
import com.gym.web.webappsv.service.impl.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Course> createCourse(@Valid @RequestBody CourseRequest req) {
        return courseService.create(req);
    }
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Course> updateCourse(@Valid @RequestBody CourseRequest req,
                                               @PathVariable("id") Long id) {
        return courseService.update(req, id);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        courseService.deleteById(id);
        return ResponseEntity.ok()
                .body(new ApiResponse(true, "Deleted courseID: "+ id + " succesfully"));
    }
}
