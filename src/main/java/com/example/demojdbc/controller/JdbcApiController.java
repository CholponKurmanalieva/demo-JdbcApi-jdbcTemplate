package com.example.demojdbc.controller;

import com.example.demojdbc.dto.EmployeeDTO;
import com.example.demojdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class JdbcApiController {
    private final EmployeeService employeeService;

    public JdbcApiController(@Qualifier("jdbcApiServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EmployeeDTO request) throws SQLException {
        if (employeeService.createEmployee(request) == 1)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeDTO>> getAll() throws SQLException {
        return ResponseEntity.ok().body(employeeService.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO) throws SQLException {
        if (employeeService.updateEmployee(id, employeeDTO) == 1)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws SQLException {
        employeeService.delete(id);
    }
}