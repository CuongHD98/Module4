package com.example.id8892.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/show")
    public String show() {
        return "show";
    }
    @PostMapping("/show")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("list", condiment);
        return "save";
    }
}
