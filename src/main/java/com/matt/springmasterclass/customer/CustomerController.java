package com.matt.springmasterclass.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable("id") UUID id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("register")
    public String createCustomer(@RequestBody Customer customer) {

    }

    @PutMapping("update")
    public String updateCustomer(@RequestBody Customer customer) {

    }

    @DeleteMapping("delete/{id}")
    public void deleteCustomer(@PathVariable("id") UUID id) {

    }

}
