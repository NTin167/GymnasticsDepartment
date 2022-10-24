package com.gym.web.webappsv.service.impl;

import com.gym.web.webappsv.exception.ResourceNotFoundException;
import com.gym.web.webappsv.model.Customer;
import com.gym.web.webappsv.payload.ApiResponse;
import com.gym.web.webappsv.payload.ClassResponse;
import com.gym.web.webappsv.payload.CustomerRequest;
import com.gym.web.webappsv.payload.CustomerResponse;
import com.gym.web.webappsv.repository.CustomerRepository;
import com.gym.web.webappsv.service.ICustomerServicce;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerServicce {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> getAllCustomer() {
        List<CustomerResponse> result = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        for(Customer item: customers) {
            CustomerResponse response = modelMapper.map(item, CustomerResponse.class);
            result.add(response);
        }
        return result;
    }

    @Override
    public ResponseEntity<Customer> addCustomer(CustomerRequest req) {
        Customer customer = new Customer();
        modelMapper.map(req, customer);
        Customer newCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CustomerResponse> updateCustomer(CustomerRequest req, Long id) {
        Customer customer = customerRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customer.setName(req.getName());
        customer.setGender(req.getGender());
        customer.setAddress(req.getAddress());
        customer.setEmail(req.getEmail());
        customer.setIdentifyCard(req.getIdentifyCard());
        customer.setDob(req.getDob());
        customer.setPhoneNumber(req.getPhoneNumber());
        Customer updateCustomer = customerRepository.save(customer);
        CustomerResponse customerResponse = new CustomerResponse();
        modelMapper.map(updateCustomer, customerResponse);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted customer"), HttpStatus.OK);
    }
}
