package com.matt.springmasterclass.customer;

import com.matt.springmasterclass.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    Customer getCustomer(UUID id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer Not Found"));
    }

}
