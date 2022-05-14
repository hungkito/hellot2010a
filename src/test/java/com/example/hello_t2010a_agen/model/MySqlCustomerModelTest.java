package com.example.hello_t2010a_agen.model;

import com.example.hello_t2010a_agen.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class MySqlCustomerModelTest {

    CustomerModel model;

    @BeforeEach
    void setUp() { model = new MySqlCustomerModel();
    }

    @Test
    void save() {
        model.save(new Customer("Duy", "012312424", "https://bloggioitre.net/wp-content/uploads/2022/01/gai-dep-gai-xinh-viet-nam.jpg", LocalDateTime.of(2004, 10, 10, 10, 10)));
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}