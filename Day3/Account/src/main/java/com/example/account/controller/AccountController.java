package com.example.account.controller;

import com.example.account.model.Account;
import com.example.account.service.AccountService;
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

    @GetMapping("/account")
    public String showAccount(Model model) {
        model.addAttribute("accountList", accountService.getAccountList());
        return "showAccount";
    }
    @GetMapping("/editAccount")
    public String showEditAccount(@RequestParam int id, Model model) {
        model.addAttribute("account", accountService.findAccountById(id));
        return "editAccount";
    }

    @PostMapping("/editAccount")
    public String editAccount(@ModelAttribute Account account, @RequestParam MultipartFile imgFile) {
        if (!imgFile.isEmpty()) {
            String fileName = imgFile.getOriginalFilename();
            try {
                imgFile.transferTo(new File("C:/Users/HDC/Desktop/Module4/Day3/Account/src/main/webapp/image/" + fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            account.setImg("/image/"+fileName);
        }
        accountService.editAccount(account.getId(), account);
        return "redirect:/account";
    }

    @GetMapping("/createAccount")
    public String showCreateAccount() {
        return "createAccount";
    }

    @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute Account account, @RequestParam MultipartFile imgFile) {
        if (!imgFile.isEmpty()) {
            String fileName = imgFile.getOriginalFilename();
            try {
                imgFile.transferTo(new File("C:/Users/HDC/Desktop/Module4/Day3/Account/src/main/webapp/image/" + fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            account.setImg("/image/"+fileName);
        }
        accountService.createAccount(account);
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
}
