package com.example.shopshoe.service.impl;

import com.example.shopshoe.model.Size;
import com.example.shopshoe.repository.SizeRepository;
import com.example.shopshoe.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeRepository sizeRepository;
    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public void save(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public void edit(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public void delete(Size size) {
        sizeRepository.delete(size);
    }

    @Override
    public Size findById(int id) {
        Optional<Size> size = sizeRepository.findById(id);
        return size.orElse(null);
    }
}
