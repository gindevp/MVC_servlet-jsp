package com.example.jstl_demo.product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product findByName(String name);
    void add(Product product);
    void edit(int id, Product product);
    void delete(int id);
}
