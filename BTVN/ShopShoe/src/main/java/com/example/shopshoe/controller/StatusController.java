package com.example.shopshoe.controller;

import com.example.shopshoe.model.Status;
import com.example.shopshoe.service.impl.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/status")
public class StatusController {
    @Autowired
    private StatusServiceImpl statusService;
    @GetMapping()
    public String showStatus(Model model) {
        model.addAttribute("statusList", statusService.getAll());
        return "adminView/status";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("statusList", statusService.getAll());
        return "adminView/statusCreate";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Status status) {
        statusService.save(status);
        return "redirect:/admin/status";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("status", statusService.findById(id));
        return "adminView/statusEdit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Status status) {
        statusService.edit(status);
        return "redirect:/admin/status";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        Status status = statusService.findById(id);
        statusService.delete(status);
        return "redirect:/admin/status";
    }
}
