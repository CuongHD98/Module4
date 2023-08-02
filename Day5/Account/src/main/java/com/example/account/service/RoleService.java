package com.example.account.service;

import com.example.account.dao.RoleDAO;
import com.example.account.model.Account;
import com.example.account.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleService {
    @Autowired
    RoleDAO roleDAO;

    public RoleService() {
    }
    public List<Role> getRoleList() {
        return roleDAO.getAll();
    }
    public Role findRoleById(int id) {
        return roleDAO.findById(id);
    }
    public int findIndexById(int id) {
        List<Role> roleList = roleDAO.getAll();
        for (int i = 0; i < roleList.size(); i++) {
            if (roleList.get(i).getId() == id) return i;
        }
        return -1;
    }
    public void editRole(Role role) {
        roleDAO.edit(role);
    }
    public void createRole(Role role) {
        roleDAO.save(role);
    }
    public void deleteRole(int id) {
        Role role = findRoleById(id);
        roleDAO.delete(role);
    }
}
