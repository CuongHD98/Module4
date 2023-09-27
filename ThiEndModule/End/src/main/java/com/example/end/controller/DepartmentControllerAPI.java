package com.example.end.controller;

import com.example.end.model.Department;
import com.example.end.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/departments")
public class DepartmentControllerAPI {
    @Autowired
    private IDepartmentService departmentService;
    @GetMapping()
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{idDepartment}")
    public ResponseEntity<Department> findById(@PathVariable int idDepartment) {
        return new ResponseEntity<>(departmentService.findById(idDepartment), HttpStatus.OK);
    }

}
