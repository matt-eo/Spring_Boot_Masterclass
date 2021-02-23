package com.matt.springmasterclass.customer;

import com.matt.springmasterclass.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        LOGGER.info("getCustomer was called");
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    Customer getCustomer(UUID id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException(
                            "Customer NOT found"
                    );
                    LOGGER.error("error in getting customer {}", notFoundException.toString());
                    return notFoundException;
                });
    }

}
