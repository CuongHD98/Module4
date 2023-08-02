package com.example.shopshoe.controller;

import com.example.shopshoe.model.Account;
import com.example.shopshoe.model.Role;
import com.example.shopshoe.service.impl.AccountServiceImpl;
import com.example.shopshoe.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/account")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private RoleServiceImpl roleService;
    @GetMapping()
    public String showAccount(Model model) {
        model.addAttribute("accountList", accountService.getAll());
        return "adminView/account";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("accountList", accountService.getAll());
        model.addAttribute("roleList", roleService.getAll());
        return "adminView/accountCreate";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Account account, @RequestParam("idRole") Role role) {
        accountService.save(account, role);
        return "redirect:/admin/account";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("account", accountService.findById(id));
        model.addAttribute("roleList", roleService.getAll());
        return "adminView/accountEdit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Account account, @RequestParam("idRole") Role role) {
        accountService.edit(account, role);
        return "redirect:/admin/account";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        Account account = accountService.findById(id);
        accountService.delete(account);
        return "redirect:/admin/account";
    }
}
