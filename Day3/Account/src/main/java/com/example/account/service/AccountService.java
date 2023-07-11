package com.example.account.service;

import com.example.account.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    List<Account> accountList;

    public AccountService() {
        accountList = new ArrayList<>();
        accountList.add(new Account(1,"Name A", "Pass A", "https://e7.pngegg.com/pngimages/799/987/png-clipart-computer-icons-avatar-icon-design-avatar-heroes-computer-wallpaper-thumbnail.png", "2000/11/01"));
        accountList.add(new Account(2,"Name B", "Pass B", "https://w7.pngwing.com/pngs/129/292/png-transparent-female-avatar-girl-face-woman-user-flat-classy-users-icon.png", "2000/11/01"));
        accountList.add(new Account(3,"Name C", "Pass C", "https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes.png", "2000/11/01"));
        accountList.add(new Account(4,"Name D", "Pass D", "https://png.pngtree.com/png-clipart/20190924/original/pngtree-user-vector-avatar-png-image_4830521.jpg", "2000/11/01"));
        accountList.add(new Account(5,"Name E", "Pass E", "https://www.pngkey.com/png/full/115-1150420_avatar-png-pic-male-avatar-icon-png.png", "2000/11/01"));
    }
    public List<Account> getAccountList() {
        return accountList;
    }
    public Account findAccountById(int id) {
        for (Account account : accountList) {
            if (account.getId() == id) return account;
        }
        return null;
    }
    public int findIndexById(int id) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getId() == id) return i;
        }
        return -1;
    }
    public void editAccount(int id, Account account) {
        int index = findIndexById(id);
        if (index != -1) {
            accountList.set(index, account);
        }
    }
    public void createAccount(Account account) {
        accountList.add(account);
    }
    public void deleteAccount(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            accountList.remove(index);
        }
    }

}
