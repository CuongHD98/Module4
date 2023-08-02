package com.example.shopshoe.service;

import com.example.shopshoe.model.Image;
import com.example.shopshoe.model.Product;


import java.util.List;

public interface ProductService {
    List<Product> getAll();

    void save(Product product, Image image);

    void edit(Product product, Image image);

    void delete(Product product);
    Product findById(int id);
}
