package com.example.shopshoe.service;

import com.example.shopshoe.model.Account;
import com.example.shopshoe.model.Role;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
    void save(Account account, Role role);
    void edit(Account account, Role role);
    void delete(Account account);
    Account findById(int id);

}
