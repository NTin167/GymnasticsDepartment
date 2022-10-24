package com.gym.web.webappsv.controller;

import com.gym.web.webappsv.model.Customer;
import com.gym.web.webappsv.payload.ApiResponse;
import com.gym.web.webappsv.payload.CustomerRequest;
import com.gym.web.webappsv.payload.CustomerResponse;
import com.gym.web.webappsv.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerRequest req) {
        return customerService.addCustomer(req);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CustomerResponse> updateCustomer(@Valid @RequestBody CustomerRequest req,
                                                           @PathVariable(name = "id") long id) {
        return customerService.updateCustomer(req, id);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable(name = "id") long id) {
        return customerService.deleteCustomer(id);
    }

}
