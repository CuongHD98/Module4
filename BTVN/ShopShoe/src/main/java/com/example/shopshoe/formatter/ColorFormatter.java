package com.example.shopshoe.formatter;

import com.example.shopshoe.model.Color;
import com.example.shopshoe.service.impl.ColorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ColorFormatter implements Formatter<Color> {
    @Autowired
    private ColorServiceImpl colorService;

    public ColorFormatter(ColorServiceImpl colorService) {
        this.colorService = colorService;
    }

    @Override
    public Color parse(String id, Locale locale) throws ParseException {
        return colorService.findById(Integer.parseInt(id));
    }

    @Override
    public String print(Color object, Locale locale) {
        return null;
    }
}
