package com.example.demo_department.models.services.impl;

import com.example.demo_department.models.dto.req.EmployeeCreateDTO;
import com.example.demo_department.models.entities.Department;
import com.example.demo_department.models.entities.Employee;
import com.example.demo_department.models.repositories.DepartmentRepository;
import com.example.demo_department.models.repositories.EmployeeRepository;
import com.example.demo_department.models.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public Employee createEmployee(EmployeeCreateDTO req){
        // tìm phòng ban theo ID từ DTO trước khi gán vào Employee
        Department department = departmentRepository.findById(req.departmentId())
                .orElseThrow(()->new RuntimeException("Department Not Found"));

        Employee employee = Employee.builder()
                .fullName(req.fullName())
                .email(req.email())
                .phone(req.phone())
                .salary(req.salary())
                .department(department)
                .build();

        return employeeRepository.save(employee);
    }


}
