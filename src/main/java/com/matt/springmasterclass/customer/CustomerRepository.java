package com.matt.springmasterclass.customer;

import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        // TODO: connect to real database
        return Collections.emptyList();
    }

}
