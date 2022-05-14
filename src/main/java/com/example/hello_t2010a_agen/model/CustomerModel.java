package com.example.hello_t2010a_agen.model;

import com.example.hello_t2010a_agen.entity.Customer;

import java.util.List;

public interface CustomerModel {
    Customer save(Customer customer);

    List<Customer> findAll();

    Customer findById(String rollNumber);

    Customer update(String rollnumber, Customer updateCustomer);

    boolean delete(String rollNumber);
}
