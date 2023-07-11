package com.cuonghd.id8874.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeController {
    @GetMapping("/change")
    public String showChange(Model model) {
        return "change";
    }
    @PostMapping("/change")
    public String change(@RequestParam int usd, float rate, Model model) {
        float vnd = usd * rate;
        model.addAttribute("vnd", vnd);
        return "change";
    }
}
