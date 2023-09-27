package com.example.end.controller;

import com.example.end.model.Employee;
import com.example.end.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/employees")
public class EmployeeControllerAPI {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/edit")
    public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee) {
        employeeService.edit(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("/delete/{idEmployee}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int idEmployee) {
        Employee employee = employeeService.findById(idEmployee);
        employeeService.deleteById(idEmployee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("/{idEmployee}")
    public ResponseEntity<Employee> viewEmployee(@PathVariable int idEmployee) {
        Employee employee = employeeService.findById(idEmployee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("/sort")
    public ResponseEntity<List<Employee>> sortByAge() {
        return new ResponseEntity<>(employeeService.sortByAge(), HttpStatus.OK);
    }


}
