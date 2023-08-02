package com.example.shopshoe.controller;

import com.example.shopshoe.model.Image;
import com.example.shopshoe.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/image")
public class ImageController {
    @Autowired
    private ImageServiceImpl imageService;
    @GetMapping()
    public String showImage(Model model) {
        model.addAttribute("imageList", imageService.getAll());
        return "adminView/image";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("imageList", imageService.getAll());
        return "adminView/imageCreate";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Image image, MultipartFile imgFile) {
        imageService.save(image, imgFile);
        return "redirect:/admin/image";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("image", imageService.findById(id));
        return "adminView/imageEdit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Image image, MultipartFile imgFile) {
        imageService.edit(image, imgFile);
        return "redirect:/admin/image";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        Image image = imageService.findById(id);
        imageService.delete(image);
        return "redirect:/admin/image";
    }
}
