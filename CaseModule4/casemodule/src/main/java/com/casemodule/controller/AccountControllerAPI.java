package com.casemodule.controller;

import com.casemodule.model.Account;
import com.casemodule.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountControllerAPI {
    @Autowired
    IAccountService accountService;
    //    @PostMapping("/login")
//    public AccountDTO getLogin(@RequestBody Account account){
//        Account account1 = accountService.getAccountLogin(account.getUsername(), account.getPassword());
//        if (account1 != null){
//            httpSession.setAttribute("account", account1);
//        }
//        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);
//        AccountDTO accountDTO = mapper.accountToAccountDTO(account1);
//        return accountDTO;
//    }
    @PostMapping("/register")
    public Account register(@RequestBody Account account){
        return account;
    }

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}