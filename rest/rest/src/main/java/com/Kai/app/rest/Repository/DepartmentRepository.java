package com.Kai.app.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Kai.app.rest.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, String> {
}

