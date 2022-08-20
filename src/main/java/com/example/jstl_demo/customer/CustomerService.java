package com.example.jstl_demo.customer;

import com.example.jstl_demo.customer.Customer;

import java.util.List;

public interface CustomerService {
    List <Customer> findAll();
    void save (Customer customer);
    Customer findById(int id);
    void update(int id, Customer customer);
    void remove(int id);

}
