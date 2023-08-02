package com.example.shopshoe.formatter;

import com.example.shopshoe.model.Size;
import com.example.shopshoe.service.impl.SizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class SizeFormatter implements Formatter<Size> {
    @Autowired
    private SizeServiceImpl sizeService;

    public SizeFormatter(SizeServiceImpl sizeService) {
        this.sizeService = sizeService;
    }

    @Override
    public Size parse(String id, Locale locale) throws ParseException {
        return sizeService.findById(Integer.parseInt(id));
    }

    @Override
    public String print(Size object, Locale locale) {
        return null;
    }
}
