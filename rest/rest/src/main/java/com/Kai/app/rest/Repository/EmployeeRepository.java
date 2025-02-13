package com.Kai.app.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kai.app.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
