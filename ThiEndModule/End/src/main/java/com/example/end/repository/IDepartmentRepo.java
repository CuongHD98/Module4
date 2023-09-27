package com.example.end.repository;

import com.example.end.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepo extends JpaRepository<Department, Integer> {
}
