package com.example.shopshoe.service.impl;

import com.example.shopshoe.model.Image;
import com.example.shopshoe.model.Product;
import com.example.shopshoe.repository.ProductRepository;
import com.example.shopshoe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product, Image image) {
        product.setImage(image);
        productRepository.save(product);
    }

    @Override
    public void edit(Product product, Image image) {
        product.setImage(image);
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product findById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
}
