package com.example.shopshoe.controller;

import com.example.shopshoe.model.Color;
import com.example.shopshoe.model.Role;
import com.example.shopshoe.service.impl.ColorServiceImpl;
import com.example.shopshoe.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/color")
public class ColorController {
    @Autowired
    private ColorServiceImpl colorService;
    @GetMapping()
    public String showColor(Model model) {
        model.addAttribute("colorList", colorService.getAll());
        return "adminView/color";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("colorList", colorService.getAll());
        return "adminView/colorCreate";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Color color) {
        colorService.save(color);
        return "redirect:/admin/color";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("color", colorService.findById(id));
        return "adminView/colorEdit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Color color) {
        colorService.edit(color);
        return "redirect:/admin/color";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        Color color = colorService.findById(id);
        colorService.delete(color);
        return "redirect:/admin/color";
    }
}
