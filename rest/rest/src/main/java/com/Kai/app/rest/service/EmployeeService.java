package com.Kai.app.rest.service;

import com.Kai.app.rest.model.Department;
import com.Kai.app.rest.model.Employee;
import com.Kai.app.rest.model.Project;
import com.Kai.app.rest.Repository.DepartmentRepository;
import com.Kai.app.rest.Repository.EmployeeRepository;
import com.Kai.app.rest.Repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Employee saveEmployee(Employee employee) {
        if (employee.getDepartment() != null) {
            Department department = departmentRepository.findById(employee.getDepartment().getDepartmentID())
                    .orElseThrow(() -> new RuntimeException("Department not found"));

            department.getEmployees().add(employee);
            departmentRepository.save(department);
        }

        if (employee.getAssignedProjects() != null && !employee.getAssignedProjects().isEmpty()) {
            for (Project project : employee.getAssignedProjects()) {
                Project existingProject = projectRepository.findById(project.getProjectID())
                        .orElseThrow(() -> new RuntimeException("Project not found"));

                existingProject.getAssignedEmployees().add(employee);
                projectRepository.save(existingProject);
            }
        }

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Optional<Employee> updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee currentEmployee = existingEmployee.get();

            currentEmployee.setName(employee.getName());
            currentEmployee.setPosition(employee.getPosition());
            currentEmployee.setDepartment(employee.getDepartment());
            currentEmployee.setAssignedProjects(employee.getAssignedProjects());

            return Optional.of(employeeRepository.save(currentEmployee));
        }
        return Optional.empty();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
