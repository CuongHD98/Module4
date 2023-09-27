package com.example.end.service;

import com.example.end.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();
    void save(Employee employee);
    void edit(Employee employee);
    void deleteById(int id);
    Employee findById(int id);
    List<Employee> sortByAge();
}
