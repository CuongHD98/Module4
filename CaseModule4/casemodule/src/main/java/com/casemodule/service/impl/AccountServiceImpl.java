package com.casemodule.service.impl;

import com.casemodule.model.Account;
import com.casemodule.model.Post;
import com.casemodule.repository.IAccountRepo;
import com.casemodule.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepo iAccountRepo;
    @Override
    public Account getAccountLogin(String username, String password) {
        return iAccountRepo.getAccountLogin(username, password);
    }

    @Override
    public List<Account> getAll() {
        return iAccountRepo.findAll();
    }

    @Override
    public Account findById(int id) {
        Optional<Account> accountOptional = iAccountRepo.findById(id);
        return accountOptional.orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.getAccountByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUsername(),account.getPassword(),roles);
    }
}
