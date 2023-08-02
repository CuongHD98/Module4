package com.example.test.controller;

import com.example.test.model.City;
import com.example.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/city")
    public String showCity(Model model) {
        model.addAttribute("cityList", cityService.getCityList());
        return "showCity";
    }
    @GetMapping("/editCity")
    public String showEditCity(@RequestParam int id, Model model) {
        model.addAttribute("city", cityService.findCityById(id));
        return "editCity";
    }

    @PostMapping("/editCity")
    public String editCity(@ModelAttribute City city, Model model) {
        cityService.editCity(city.getId(), city);
        model.addAttribute("message", "Edit Successful !");
        return "editCity";
    }

    @GetMapping("/createCity")
    public String showCreateCity() {
        return "createCity";
    }

    @PostMapping("/createCity")
    public String createCity(@ModelAttribute City city, Model model) {
        cityService.createCity(city);
        model.addAttribute("message", "Create Successful !");
        return "createCity";
    }
    @GetMapping("/deleteCity")
    public String showDeleteCity(@RequestParam int id, Model model) {
        model.addAttribute("city", cityService.findCityById(id));
        return "deleteCity";
    }
    @PostMapping("/deleteCity")
    public String deleteCity(@RequestParam int id, Model model) {
        cityService.deleteCity(id);
        model.addAttribute("message", "Delete Successful !");
        return "deleteCity";
    }
    @GetMapping("/viewCity")
    public String viewCity(@RequestParam int id, Model model) {
        model.addAttribute("city", cityService.findCityById(id));
        return "viewCity";
    }
}
