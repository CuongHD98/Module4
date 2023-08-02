package com.example.shopshoe.formatter;

import com.example.shopshoe.model.Role;
import com.example.shopshoe.service.RoleService;
import com.example.shopshoe.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class RoleFormatter implements Formatter<Role> {
    @Autowired
    private RoleServiceImpl roleService;

    public RoleFormatter(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @Override
    public Role parse(String id, Locale locale) throws ParseException {
        return roleService.findById(Integer.parseInt(id));
    }

    @Override
    public String print(Role object, Locale locale) {
        return null;
    }
}
