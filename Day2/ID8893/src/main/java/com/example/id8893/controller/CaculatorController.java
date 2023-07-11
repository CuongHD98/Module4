package com.example.id8893.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/caculator")
    public String show() {
        return "caculator";
    }
    @PostMapping("/caculator")
    public String caculator(@RequestParam int num1, int num2, String pheptinh, Model model) {
        switch (pheptinh) {
            case "+": {
                int result = num1 + num2;
                model.addAttribute("result", result);
                break;
            }
            case "-": {
                int result = num1 - num2;
                model.addAttribute("result", result);
                break;
            }
            case "*": {
                int result = num1 * num2;
                model.addAttribute("result", result);
                break;
            }
            default:
                if (num2 == 0) {
                    String result = "So bi chia khong the bang 0 !";
                    model.addAttribute("result", result);
                } else {
                    int result = num1 / num2;
                    model.addAttribute("result", result);
                }
                break;
        }
        return "caculator";
    }

}
