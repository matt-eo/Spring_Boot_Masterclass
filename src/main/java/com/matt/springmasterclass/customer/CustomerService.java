package com.matt.springmasterclass.customer;

import com.matt.springmasterclass.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j // Lombok will provide logger accessible via 'log.'
public class CustomerService {

    // Now provided by Lombok
    // private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        log.info("getCustomer was called");
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
                    log.error("error in getting customer {}", notFoundException.toString());
                    return notFoundException;
                });
    }

    void saveCustomer(Customer customer) {
        log.info("Saving Customer...");
        customerRepo.save(customer);
    }

    void updateCustomer(Customer customer, UUID id) {
        Optional<Customer> maybeCustomer = customerRepo.findById(id);
        if (maybeCustomer.isEmpty()) {
            throw new IllegalStateException("The customer with id this id does not exist");
        }
        Customer toUpdate = new Customer(customer);
        customerRepo.save(toUpdate);
    }

    void deleteCustomerById(UUID id) {
        Optional<Customer> maybeCustomer = customerRepo.findById(id);
        if (maybeCustomer.isEmpty()) {
            throw new IllegalStateException("The customer with id this id does not exist");
        }
        customerRepo.deleteById(id);
    }

}
