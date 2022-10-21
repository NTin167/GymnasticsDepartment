package com.gym.web.webappsv.service.impl;

import com.gym.web.webappsv.exception.BadRequestException;
import com.gym.web.webappsv.exception.ResourceNotFoundException;
import com.gym.web.webappsv.model.Staff;
import com.gym.web.webappsv.payload.PagedResponse;
import com.gym.web.webappsv.payload.StaffRequest;
import com.gym.web.webappsv.payload.StaffResponse;
import com.gym.web.webappsv.repository.StaffRepository;
import com.gym.web.webappsv.security.UserPrincipal;
import com.gym.web.webappsv.service.IStaffService;
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

@Service
public class StaffService implements IStaffService {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private ModelMapper modelMapper;


    public PagedResponse<StaffResponse> getAllStaffs(int page, int size) {
        validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Staff> staffs = staffRepository.findAll(pageable);
        if(staffs.getTotalElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), staffs.getNumber(),
                    staffs.getSize(), staffs.getTotalElements(), staffs.getTotalPages(), staffs.isLast());
        }
        List<StaffResponse> staffResponses = staffs.map(staff -> {
            return modelMapper.map(staff, StaffResponse.class);
        }).getContent();
        return new PagedResponse<>(staffResponses, staffs.getNumber(),
                staffs.getSize(), staffs.getTotalElements(), staffs.getTotalPages(), staffs.isLast());
    }
    public Staff createStaff(StaffRequest req) {
        Staff staff = Staff.builder()
                .name(req.getName())
                .gender(req.getGender())
                .address(req.getAddress())
                .dob(req.getDob())
                .status(req.isStatus())
                .identifyCard(req.getIdentifyCard())
                .phoneNumber(req.getPhoneNumber())
                .build();
        return staffRepository.save(staff);
    }
    public StaffResponse updateStaff(StaffRequest req, Long staffId) {
        Staff staff =  staffRepository.findById(staffId)
                .orElseThrow(() -> new ResourceNotFoundException("Staff", "id", staffId));
        staff.setName(req.getName());
        staff.setAddress(req.getAddress());
        staff.setDob(req.getDob());
        staff.setGender(req.getGender());
        staff.setIdentifyCard(req.getIdentifyCard());
        staff.setPhoneNumber(req.getPhoneNumber());
        return modelMapper.map(staffRepository.save(staff), StaffResponse.class);
    }
    public void deleteStaff(Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Staff", "id", id));
        staffRepository.delete(staff);
    }
    private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}
