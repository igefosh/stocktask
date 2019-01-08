package com.igefosh.service;

import com.igefosh.entity.Product;

import java.util.List;

public interface ProductService {

    Product getById(int id);

    void save (Product product);

    void update (Product product);

    void delete (int id);

    List<Product> findAll();
}
