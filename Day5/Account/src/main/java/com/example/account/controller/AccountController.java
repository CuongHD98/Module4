package com.example.account.controller;

import com.example.account.dao.AccountDAO;
import com.example.account.model.Account;
import com.example.account.model.Role;
import com.example.account.service.AccountService;
import com.example.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;
    @Autowired
    AccountDAO accountDAO;

    @GetMapping("/account")
    public String showAccount(Model model) {
        model.addAttribute("accountList", accountService.getAccountList());
        return "showAccount";
    }
    @GetMapping("/editAccount")
    public String showEditAccount(@RequestParam int id, Model model) {
        model.addAttribute("account", accountService.findAccountById(id));
        model.addAttribute("roleList", roleService.getRoleList());
        return "editAccount";
    }

    @PostMapping("/editAccount")
    public String editAccount(@ModelAttribute Account account, @RequestParam MultipartFile imgFile, int roleInput) {
        accountService.editAccount(account, imgFile, roleInput);
        return "redirect:/account";
    }

    @GetMapping("/createAccount")
    public String showCreateAccount(Model model) {
        model.addAttribute("roleList", roleService.getRoleList());
        return "createAccount";
    }

    @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute Account account, @RequestParam MultipartFile imgFile, int roleInput) {
        accountService.createAccount(account, imgFile, roleInput);
        return "redirect:/account";
    }
    @GetMapping("/deleteAccount")
    public String showDeleteAccount(@RequestParam int id, Model model) {
        model.addAttribute("account", accountService.findAccountById(id));
        return "deleteAccount";
    }
    @PostMapping("/deleteAccount")
    public String deleteCustomer(@RequestParam int id) {
        accountService.deleteAccount(id);
        return "redirect:/account";
    }
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, String password, Model model) {
        Account account = accountService.login(username, password);
        if (account != null) {
            return "redirect:/account";
        } else {
            model.addAttribute("message", "Not found account !");
            return "login";
        }
    }
}
