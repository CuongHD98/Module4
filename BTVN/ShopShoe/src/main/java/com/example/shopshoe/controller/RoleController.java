package com.example.shopshoe.controller;

import com.example.shopshoe.model.Role;
import com.example.shopshoe.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;
    @GetMapping()
    public String showRole(Model model) {
        model.addAttribute("roleList", roleService.getAll());
        return "adminView/role";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("roleList", roleService.getAll());
        return "adminView/roleCreate";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Role role) {
        roleService.save(role);
        return "redirect:/admin/role";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("role", roleService.findById(id));
        return "adminView/roleEdit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Role role) {
        roleService.edit(role);
        return "redirect:/admin/role";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        Role role = roleService.findById(id);
        roleService.delete(role);
        return "redirect:/admin/role";
    }

}
