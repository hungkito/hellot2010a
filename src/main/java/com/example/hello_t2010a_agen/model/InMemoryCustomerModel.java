package com.example.hello_t2010a_agen.model;

import com.example.hello_t2010a_agen.entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements CustomerModel{

    private static List<Customer> customers;

    public InMemoryCustomerModel(){
        customers = new ArrayList<>();
        customers.add(
                new Customer(
                        "1",
                        "Phung Hung",
                        "0124452141",
                        "https://bloggioitre.net/wp-content/uploads/2022/01/gai-dep-gai-xinh-viet-nam.jpg",
                        LocalDateTime.of(2004,10,10,0,0)
                )
        );
        customers.add(
        new Customer(
                "2",
                "Phung Viet",
                "0124452141",
                "https://bloggioitre.net/wp-content/uploads/2022/01/gai-dep-gai-xinh-viet-nam.jpg",
                LocalDateTime.of(2004,10,10,0,0)
        )
        );
        customers.add(
        new Customer(
                "3",
                "Duc Duy",
                "0124452141",
                "https://bloggioitre.net/wp-content/uploads/2022/01/gai-dep-gai-xinh-viet-nam.jpg",
                LocalDateTime.of(2004,10,10,0,0)
        )
        );
        customers.add(
        new Customer(
                "4",
                "Dao Thang",
                "0124452141",
                "https://bloggioitre.net/wp-content/uploads/2022/01/gai-dep-gai-xinh-viet-nam.jpg",
                LocalDateTime.of(2004,10,10,0,0)
        )
        );
    }

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String rollNumber) {
        Customer foundCustomer = null;
        for (Customer customer:
              customers) {
            if (customer.getRollnumber() == rollNumber){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    @Override
    public Customer update(String rollNumber, Customer updateCustomer) {
        Customer existingCustomer =findById(rollNumber);
        if (existingCustomer == null){
            return null;
        }
        existingCustomer.setName(updateCustomer.getName());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setImage(updateCustomer.getImage());
        existingCustomer.setDob(updateCustomer.getDob());
        existingCustomer.setUpdatedAt(updateCustomer.getUpdatedAt());
        existingCustomer.setStatus(updateCustomer.getStatus());
        return existingCustomer;
    }

    @Override
    public boolean delete(String rollNumber) {
        int foundIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getRollnumber() == rollNumber){
                foundIndex = 1;
            }
        }
        if (foundIndex != -1){
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }
}
