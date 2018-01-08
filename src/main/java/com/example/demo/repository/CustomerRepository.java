package com.example.demo.repository;

import com.example.demo.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chamith
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("SELECT customer FROM Customer customer WHERE customer.customerName = :customerName")
    Customer findCustomerByName(@Param("customerName") String customerName);
}
