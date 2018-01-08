package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chamith
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_")
    private Long id;

    @Column(name = "CUSTOMER_NAME_")
    private String customerName;

    @Column(name = "CONTACT_NO_")
    private String contactNo;

    @Column(name = "ADDRESS")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("com.example.demo.domain.Customer{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
