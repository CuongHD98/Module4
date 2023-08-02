package com.example.shopshoe.controller.restful;

import com.example.shopshoe.model.Role;
import com.example.shopshoe.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleRestController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/roles")
    public List<Role> showRole() {
        return roleService.getAll();
    }
    @GetMapping("/roles/{id}")
    public Role findRole(@PathVariable int id) {
        return roleService.findById(id);
    }
    @PostMapping("/roles")
    public String createRole(@RequestBody Role role) {
        roleService.save(role);
        return "Create Successful !";
    }
    @DeleteMapping("/roles/{id}")
    public String deleteRole(@PathVariable int id) {
        Role role = roleService.findById(id);
        roleService.delete(role);
        return "Delete Successful !";
    }
    @PutMapping("/roles/{id}")
    public String editRole(@PathVariable int id, @RequestBody Role role) {
        role.setId(id);
        roleService.edit(role);
        return "Edit Successful !";
    }

}
