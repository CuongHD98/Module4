package com.example.end.service.impl;

import com.example.end.model.Department;
import com.example.end.model.Employee;
import com.example.end.repository.IDepartmentRepo;
import com.example.end.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private IDepartmentRepo iDepartmentRepo;
    @Override
    public List<Department> getAll() {
        return iDepartmentRepo.findAll();
    }

    @Override
    public Department findById(int id) {
        Optional<Department> departmentOptional = iDepartmentRepo.findById(id);
        return departmentOptional.orElse(null);
    }
}
