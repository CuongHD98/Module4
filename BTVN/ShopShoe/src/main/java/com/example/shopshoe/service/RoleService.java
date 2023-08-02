package com.example.shopshoe.service;

import com.example.shopshoe.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    void save(Role role);
    void edit(Role role);
    void delete(Role role);
    Role findById(int id);
}
