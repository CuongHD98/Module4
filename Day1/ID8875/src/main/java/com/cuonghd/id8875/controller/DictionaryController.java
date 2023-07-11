package com.cuonghd.id8875.controller;

import com.cuonghd.id8875.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;
    @GetMapping("/dictionary")
    public String showChange() {
        return "dictionary";
    }
    @PostMapping("/dictionary")
    public String change(@RequestParam String english, Model model) {
        String vietnam = dictionaryService.changeEnglishToVietNam(english);
        model.addAttribute("vietnam", vietnam);
        return "dictionary";
    }

}
