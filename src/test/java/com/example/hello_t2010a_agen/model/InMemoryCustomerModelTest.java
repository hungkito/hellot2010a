package com.example.hello_t2010a_agen.model;

import com.example.hello_t2010a_agen.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCustomerModelTest {

    InMemoryCustomerModel model;

    @BeforeEach
    void setUp() { model = new InMemoryCustomerModel();
    }

    @Test
    void save() {
        System.out.println(model.findAll().size());
        Customer customer = new Customer(
                005,
                "Nguyen Hoang",
                "03316245",
                "https://bloggioitre.net/wp-content/uploads/2022/01/gai-dep-gai-xinh-viet-nam.jpg",
                LocalDateTime.of(2000, 10, 10, 0, 0)
        );
        model.save(customer);
        System.out.println(model.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(model.findAll().size());
    }

    @Test
    void findById() {
        Customer customer = model.findById(001);
        System.out.println(customer.toString());
    }

    @Test
    void update() {
        Customer customer = model.findById(001);
        customer.setName("Phung Viet Hung");
        model.update(001, customer);
        for (Customer ct: model.findAll()) {
            System.out.println(ct.toString());
        }
    }

    @Test
    void delete() {
        model.delete(001);
        for (Customer ct: model.findAll()) {
            System.out.println(ct.toString());
        }
    }
}