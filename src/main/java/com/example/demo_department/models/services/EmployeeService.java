package com.example.demo_department.models.services;

import com.example.demo_department.models.dto.req.EmployeeCreateDTO;
import com.example.demo_department.models.entities.Employee;

public interface EmployeeService {
    Employee createEmployee(EmployeeCreateDTO req);
}
