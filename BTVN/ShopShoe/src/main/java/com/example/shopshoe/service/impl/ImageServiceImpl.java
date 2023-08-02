package com.example.shopshoe.service.impl;

import com.example.shopshoe.model.Image;
import com.example.shopshoe.repository.ImageRepository;
import com.example.shopshoe.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public void save(Image image, MultipartFile imgFile) {
        setSrcImageFromFile(image, imgFile);
        imageRepository.save(image);
    }

    @Override
    public void edit(Image image, MultipartFile imgFile) {
        setSrcImageFromFile(image, imgFile);
        imageRepository.save(image);
    }

    @Override
    public void delete(Image image) {
        imageRepository.delete(image);
    }

    @Override
    public Image findById(int id) {
        Optional<Image> image = imageRepository.findById(id);
        return image.orElse(null);
    }

    public void setSrcImageFromFile(Image image, MultipartFile imgFile){
        if (!imgFile.isEmpty()) {
            String fileName = imgFile.getOriginalFilename();
            try {
                imgFile.transferTo(new File("C:\\Users\\HDC\\Desktop\\Module4\\BTVN\\ShopShoe\\src\\main\\webapp\\images/" + fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            image.setSrc("/images/"+fileName);
        }
    }
}
