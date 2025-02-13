package com.Kai.app.rest.service;

import com.Kai.app.rest.model.Department;
import com.Kai.app.rest.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(String departmentID) {
        return departmentRepository.findById(departmentID);
    }

    public Optional<Department> updateDepartment(String departmentID, Department department) {
        Optional<Department> existingDepartment = departmentRepository.findById(departmentID);
        if (existingDepartment.isPresent()) {
            Department currentDepartment = existingDepartment.get();
            currentDepartment.setDepartmentName(department.getDepartmentName());
            currentDepartment.setEmployees(department.getEmployees());

            return Optional.of(departmentRepository.save(currentDepartment));
        }
        return Optional.empty();
    }

    public void deleteDepartment(String departmentID) {
        departmentRepository.deleteById(departmentID);
    }
}
