package com.example.demo_department.controllers;

import com.example.demo_department.models.dto.req.EmployeeCreateDTO;
import com.example.demo_department.models.dto.response.ApiResponse;
import com.example.demo_department.models.entities.Employee;
import com.example.demo_department.models.repositories.EmployeeRepository;
import com.example.demo_department.models.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeCreateDTO req){
        Employee createdEmployee = employeeService.createEmployee(req);

        ApiResponse<Employee> response = ApiResponse.<Employee>builder()
                .status("SUCCESS")
                .message("Thêm mới nhân viên thành công")
                .data(createdEmployee)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

}
