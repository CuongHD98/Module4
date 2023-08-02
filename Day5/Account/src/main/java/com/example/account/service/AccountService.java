package com.example.account.service;

import com.example.account.dao.AccountDAO;
import com.example.account.model.Account;
import com.example.account.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Component
public class AccountService {
    @Autowired
    AccountDAO accountDAO;
    @Autowired
    RoleService roleService;

    public AccountService() {
    }

    public List<Account> getAccountList() {
        return accountDAO.getAll();
    }
    public Account findAccountById(int id) {
        return accountDAO.findById(id);
    }
    public int findIndexById(int id) {
        List<Account> accountList = accountDAO.getAll();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getId() == id) return i;
        }
        return -1;
    }
    public void editAccount(Account account, MultipartFile imgFile, int roleInput) {
        if (!imgFile.isEmpty()) {
            String fileName = imgFile.getOriginalFilename();
            try {
                imgFile.transferTo(new File("C:\\Users\\HDC\\Desktop\\Module4\\Day5\\Account\\src\\main\\webapp\\image/" + fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            account.setAvatar("/image/"+fileName);
        }
        Role role = roleService.findRoleById(roleInput);
        account.setRole(role);
        accountDAO.edit(account);
    }
    public void createAccount(Account account, MultipartFile imgFile, int roleInput) {
        if (!imgFile.isEmpty()) {
            String fileName = imgFile.getOriginalFilename();
            try {
                imgFile.transferTo(new File("C:\\Users\\HDC\\Desktop\\Module4\\Day5\\Account\\src\\main\\webapp\\image/" + fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            account.setAvatar("/image/"+fileName);
        }
        Role role = roleService.findRoleById(roleInput);
        account.setRole(role);
        accountDAO.save(account);
    }
    public void deleteAccount(int id) {
        Account account = findAccountById(id);
        accountDAO.delete(account);
    }
    public Account login(String username, String password) {
        List<Account> accountList = accountDAO.getAll();
        for (Account account : accountList) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

}
