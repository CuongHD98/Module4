package com.example.end.repository;

import com.example.end.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Employee order by age")
    List<Employee> sortByAge();

}
