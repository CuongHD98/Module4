package com.example.shopshoe.formatter;

import com.example.shopshoe.model.Product;
import com.example.shopshoe.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ProductFormatter implements Formatter<Product> {
    @Autowired
    private ProductServiceImpl productService;
    public ProductFormatter(ProductServiceImpl productService) {
        this.productService = productService;
    }
    @Override
    public Product parse(String id, Locale locale) throws ParseException {
        return productService.findById(Integer.parseInt(id));
    }

    @Override
    public String print(Product object, Locale locale) {
        return null;
    }
}
