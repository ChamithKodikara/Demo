package com.example.demo.service;

import com.example.demo.domain.Customer;

import java.util.List;

/**
 * @author chamith
 */

public interface CustomerService {
    void addNewCustomer(Customer customer);

    List<Customer> getAllCustomerList();

    Customer findCustomerDetailsByName(String name);
}
