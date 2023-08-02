package com.example.shopshoe.controller;

import com.example.shopshoe.model.Color;
import com.example.shopshoe.model.Size;
import com.example.shopshoe.service.impl.ColorServiceImpl;
import com.example.shopshoe.service.impl.SizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/size")
public class SizeController {
    @Autowired
    private SizeServiceImpl sizeService;
    @GetMapping()
    public String showSize(Model model) {
        model.addAttribute("sizeList", sizeService.getAll());
        return "adminView/size";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("sizeList", sizeService.getAll());
        return "adminView/sizeCreate";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Size size) {
        sizeService.save(size);
        return "redirect:/admin/size";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("size", sizeService.findById(id));
        return "adminView/sizeEdit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Size size) {
        sizeService.edit(size);
        return "redirect:/admin/size";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        Size size = sizeService.findById(id);
        sizeService.delete(size);
        return "redirect:/admin/size";
    }
}
