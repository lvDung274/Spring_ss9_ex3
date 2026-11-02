package com.example.demo_department.exceptions;

import com.example.demo_department.models.dto.response.ApiResponse;
import com.example.demo_department.models.entities.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(err -> errors.put(err.getField(),err.getDefaultMessage()));

        ApiResponse<?> apiResponse = ApiResponse.builder()
                .status("Fail")
                .message("Dữ liệu đầu vào không hợp lệ")
                .data(errors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

}
