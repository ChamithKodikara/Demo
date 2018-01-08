package com.example.demo.service.impl;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author chamith
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void addNewCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Customer> getAllCustomerList() {
        List<Customer> customerList;
        try {
            customerList = (List<Customer>) customerRepository.findAll();
        } catch (Exception ex) {
            customerList = null;
            LOGGER.error(ex.getMessage(), ex);
        }
        return customerList;
    }

    @Override
    public Customer findCustomerDetailsByName(String name) {
        return customerRepository.findCustomerByName(name);
    }
}
