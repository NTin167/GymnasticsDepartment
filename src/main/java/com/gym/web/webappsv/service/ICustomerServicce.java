package com.gym.web.webappsv.service;

import com.gym.web.webappsv.model.Customer;
import com.gym.web.webappsv.payload.ApiResponse;
import com.gym.web.webappsv.payload.CustomerRequest;
import com.gym.web.webappsv.payload.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerServicce {
    List<CustomerResponse> getAllCustomer();
    ResponseEntity<Customer> addCustomer(CustomerRequest req);
    ResponseEntity<CustomerResponse> updateCustomer(CustomerRequest customer, Long id);
    ResponseEntity<ApiResponse> deleteCustomer(Long id);
}
