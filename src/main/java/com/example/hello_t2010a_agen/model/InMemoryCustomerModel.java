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
                        001,
                        "Phung Hung",
                        "0124452141",
                        "https://bloggioitre.net/wp-content/uploads/2022/01/gai-dep-gai-xinh-viet-nam.jpg",
                        LocalDateTime.of(2004,10,10,0,0)
                )
        );
        customers.add(
        new Customer(
                002,
                "Phung Viet",
                "0124452141",
                "https://bloggioitre.net/wp-content/uploads/2022/01/gai-dep-gai-xinh-viet-nam.jpg",
                LocalDateTime.of(2004,10,10,0,0)
        )
        );
        customers.add(
        new Customer(
                003,
                "Duc Duy",
                "0124452141",
                "https://bloggioitre.net/wp-content/uploads/2022/01/gai-dep-gai-xinh-viet-nam.jpg",
                LocalDateTime.of(2004,10,10,0,0)
        )
        );
        customers.add(
        new Customer(
                004,
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
    public Customer findById(int id) {
        Customer foundCustomer = null;
        for (Customer customer:
              customers) {
            if (customer.getId() == id){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    @Override
    public Customer update(int id, Customer updateCustomer) {
        Customer existingCustomer =findById(id);
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
    public boolean delete(int id) {
        int foundIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id){
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
