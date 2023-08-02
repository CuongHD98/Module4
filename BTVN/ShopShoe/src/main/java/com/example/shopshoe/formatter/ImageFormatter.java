package com.example.shopshoe.formatter;

import com.example.shopshoe.model.Image;
import com.example.shopshoe.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ImageFormatter implements Formatter<Image> {
    @Autowired
    private ImageServiceImpl imageService;

    public ImageFormatter(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @Override
    public Image parse(String id, Locale locale) throws ParseException {
        return imageService.findById(Integer.parseInt(id));
    }

    @Override
    public String print(Image object, Locale locale) {
        return null;
    }
}
