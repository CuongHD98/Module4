package com.example.shopshoe.service.impl;

import com.example.shopshoe.model.Account;
import com.example.shopshoe.model.Role;
import com.example.shopshoe.repository.AccountRepository;
import com.example.shopshoe.service.AccountService;
import com.example.shopshoe.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleService roleService;
    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public void save(Account account, Role role) {
        account.setRole(role);
        accountRepository.save(account);
    }

    @Override
    public void edit(Account account, Role role) {
        account.setRole(role);
        accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account findById(int id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }
}
