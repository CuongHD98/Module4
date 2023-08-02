package com.example.shopshoe.service;

import com.example.shopshoe.model.Size;

import java.util.List;

public interface SizeService {
    List<Size> getAll();
    void save(Size size);
    void edit(Size size);
    void delete(Size size);
    Size findById(int id);
}
