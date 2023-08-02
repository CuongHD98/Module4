package com.example.shopshoe.service;

import com.example.shopshoe.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    List<Image> getAll();
    void save(Image image, MultipartFile imgFile);
    void edit(Image image, MultipartFile imgFile);
    void delete(Image image);
    Image findById(int id);
}
