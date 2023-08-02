package com.casemodule.controller;

import com.casemodule.model.Account;
import com.casemodule.model.dto.AccountToken;
import com.casemodule.service.IAccountService;
import com.casemodule.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    IAccountService accountService;


    @PostMapping("/login")
    public AccountToken getLogin(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        account = accountService.getAccountLogin(account.getUsername(), account.getPassword());
        String token;
        token = jwtService.createToken(authentication);
        return new AccountToken(account.getId(), account.getUsername(), account.getPassword(),
                account.getRole(), token);
    }
}