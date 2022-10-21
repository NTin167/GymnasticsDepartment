package com.gym.web.webappsv.controller;

import com.gym.web.webappsv.model.Staff;
import com.gym.web.webappsv.payload.ApiResponse;
import com.gym.web.webappsv.payload.PagedResponse;
import com.gym.web.webappsv.payload.StaffRequest;
import com.gym.web.webappsv.payload.StaffResponse;
import com.gym.web.webappsv.security.JwtAuthenticationFilter;
import com.gym.web.webappsv.security.JwtTokenProvider;
import com.gym.web.webappsv.service.impl.StaffService;
import com.gym.web.webappsv.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/staff")
public class DeptController {
    @Autowired
    StaffService staffService;
    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    JwtAuthenticationFilter filter;

    @GetMapping("/{page}/{size}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PagedResponse<StaffResponse> getAllStaffs(@PathVariable(value = "page") int page,
                                                     @PathVariable(value = "size") int size) {
        return staffService.getAllStaffs(page, size);
    }
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createStaff(@Valid @RequestBody StaffRequest staffRequest) {
        Staff staff = staffService.createStaff(staffRequest);
        return ResponseEntity.ok().body(new ApiResponse(true, "Staff created succesfully"));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public StaffResponse updateStaff(@Valid @RequestBody StaffRequest staffRequest, @PathVariable Long id) {

        return staffService.updateStaff(staffRequest, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.ok().body(new ApiResponse(true, "Staff deleted succesfully"));
    }
}
