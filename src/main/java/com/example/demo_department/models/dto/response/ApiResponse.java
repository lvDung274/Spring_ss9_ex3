package com.example.demo_department.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse <T>{
    private String status;
    private String message;
    private T data;
}
