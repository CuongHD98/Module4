package com.example.shopshoe.service.impl;

import com.example.shopshoe.model.Color;
import com.example.shopshoe.model.Product;
import com.example.shopshoe.model.ProductDetail;
import com.example.shopshoe.model.Size;
import com.example.shopshoe.repository.ProductDetailRepository;
import com.example.shopshoe.repository.ProductRepository;
import com.example.shopshoe.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Override
    public List<ProductDetail> getAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public void save(ProductDetail productDetail, Product product, Color color, Size size) {
        productDetail.setProduct(product);
        productDetail.setColor(color);
        productDetail.setSize(size);
        productDetailRepository.save(productDetail);
    }

    @Override
    public void edit(ProductDetail productDetail, Product product, Color color, Size size) {
        productDetail.setProduct(product);
        productDetail.setColor(color);
        productDetail.setSize(size);
        productDetailRepository.save(productDetail);
    }

    @Override
    public void delete(ProductDetail productDetail) {
        productDetailRepository.delete(productDetail);
    }

    @Override
    public ProductDetail findById(int id) {
        Optional<ProductDetail> productDetail = productDetailRepository.findById(id);
        return productDetail.orElse(null);
    }
}
