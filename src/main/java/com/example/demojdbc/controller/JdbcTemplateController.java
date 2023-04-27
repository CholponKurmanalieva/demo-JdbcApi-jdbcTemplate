package com.example.demojdbc.controller;

import com.example.demojdbc.dto.EmployeeDTO;
import com.example.demojdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/template")
public class JdbcTemplateController {
    private final EmployeeService employeeService;

    public JdbcTemplateController(@Qualifier("jdbcTemplateServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EmployeeDTO employeeDTO) throws SQLException {
        employeeService.createEmployee(employeeDTO);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO) throws SQLException {
        employeeService.updateEmployee(id, employeeDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeDTO>> getAll() throws SQLException {
        return ResponseEntity.ok().body(employeeService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") Long id) throws SQLException {
        employeeService.delete(id);
    }
}