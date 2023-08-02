package com.example.shopshoe.service.impl;

import com.example.shopshoe.model.Color;
import com.example.shopshoe.repository.ColorRepository;
import com.example.shopshoe.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public void save(Color color) {
        colorRepository.save(color);
    }

    @Override
    public void edit(Color color) {
        colorRepository.save(color);
    }

    @Override
    public void delete(Color color) {
        colorRepository.delete(color);
    }

    @Override
    public Color findById(int id) {
        Optional<Color> color = colorRepository.findById(id);
        return color.orElse(null);
    }
}
