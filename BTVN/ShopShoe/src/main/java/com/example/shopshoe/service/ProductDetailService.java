package com.example.shopshoe.service;

import com.example.shopshoe.model.Color;
import com.example.shopshoe.model.Product;
import com.example.shopshoe.model.ProductDetail;
import com.example.shopshoe.model.Size;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAll();

    void save(ProductDetail productDetail, Product product, Color color, Size size);

    void edit(ProductDetail productDetail, Product product, Color color, Size size);

    void delete(ProductDetail productDetail);
    ProductDetail findById(int id);
}
