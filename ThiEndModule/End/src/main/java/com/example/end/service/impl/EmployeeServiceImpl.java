package com.example.end.service.impl;

import com.example.end.model.Employee;
import com.example.end.repository.IEmployeeRepo;
import com.example.end.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepo iEmployeeRepo;
    @Override
    public List<Employee> getAll() {
        return iEmployeeRepo.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepo.save(employee);
    }

    @Override
    public void edit(Employee employee) {
        iEmployeeRepo.save(employee);
    }

    @Override
    public void deleteById(int id) {
        iEmployeeRepo.deleteById(id);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employeeOptional = iEmployeeRepo.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public List<Employee> sortByAge() {
        return iEmployeeRepo.sortByAge();
    }
}
