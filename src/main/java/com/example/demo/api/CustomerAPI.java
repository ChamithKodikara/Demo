package com.example.demo.api;


import com.example.demo.domain.Customer;
import com.example.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chamith
 */
@RestController
@RequestMapping("/customer")
public class CustomerAPI {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CustomerService customerService;

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping("/add")
    public String addCustomer() {
        Customer customer = new Customer();
        customer.setCustomerName("Chamith");
        customer.setAddress("Matara");
        customer.setContactNo("0714948048");
        customerService.addNewCustomer(customer);
        return "Success";
    }

    @RequestMapping("/all")
    public String allCustomer() {
        List<Customer> customerList = customerService.getAllCustomerList();
        customerList.forEach(customer -> {
            LOGGER.info(customer.getCustomerName());
        });
        return "Success";
    }

    @RequestMapping("/name")
    public Customer getCustomerByName() {
        return customerService.findCustomerDetailsByName("Chamith");
    }
}
