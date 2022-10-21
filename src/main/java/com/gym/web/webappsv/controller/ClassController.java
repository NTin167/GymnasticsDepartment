package com.gym.web.webappsv.controller;

import com.gym.web.webappsv.DTO.ClassDTO;
import com.gym.web.webappsv.model.Class;
import com.gym.web.webappsv.payload.*;
import com.gym.web.webappsv.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/class")
public class ClassController {
    @Autowired
    private IClassService classService;
    @GetMapping
    public List<ClassResponse> showClass(ClassDTO classDTO) {
        return classService.findAll();
    }
    @GetMapping("/{page}/{size}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PagedResponse<ClassResponse> getAllStaffs(@PathVariable(value = "page") int page,
                                                     @PathVariable(value = "size") int size) {
        return classService.getAllClasses(page, size);
    }
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createClass(@Valid @RequestBody ClassRequest req) {
        Class aClass = classService.create(req);
        return ResponseEntity.ok()
                .body(new ApiResponse(true, "Class created succesfully"));
    }
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ClassResponse updateClass(@RequestBody ClassRequest req,
                                     @PathVariable("id") long id) {
        return classService.update(req, id);

    }
    @DeleteMapping()
    public void deleteClasses(@RequestBody long[] ids){
        classService.delete(ids);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long id) {
        classService.deleteById(id);
    }
}
