package com.gym.web.webappsv.service;

import com.gym.web.webappsv.model.Staff;
import com.gym.web.webappsv.payload.StaffRequest;
import com.gym.web.webappsv.payload.StaffResponse;

public interface IStaffService {
     Staff createStaff(StaffRequest req);
     StaffResponse updateStaff(StaffRequest req, Long staffId);
     void deleteStaff(Long id);
}
