package com.example.end.service;

import com.example.end.model.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAll();
    Department findById(int id);
}
