package com.example.shopshoe.service;

import com.example.shopshoe.model.Color;

import java.util.List;

public interface ColorService {
    List<Color> getAll();
    void save(Color color);
    void edit(Color color);
    void delete(Color color);
    Color findById(int id);
}
