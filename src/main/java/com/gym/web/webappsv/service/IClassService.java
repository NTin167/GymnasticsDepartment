package com.gym.web.webappsv.service;

import com.gym.web.webappsv.DTO.ClassDTO;
import com.gym.web.webappsv.model.Class;
import com.gym.web.webappsv.payload.ClassRequest;
import com.gym.web.webappsv.payload.ClassResponse;
import com.gym.web.webappsv.payload.PagedResponse;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IClassService {
    List<ClassResponse> findAll();
    Class create(ClassRequest req);
    ClassResponse update(ClassRequest req, Long classId);
    void delete(long[] ids);
    void deleteById(long id);
    PagedResponse<ClassResponse> getAllClasses(int page, int size);
}
