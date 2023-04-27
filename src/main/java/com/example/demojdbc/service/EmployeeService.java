package com.example.demojdbc.service;

import com.example.demojdbc.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    int createEmployee(EmployeeDTO request) throws SQLException;
    List<EmployeeDTO> getAll() throws SQLException;
    int updateEmployee(Long id, EmployeeDTO employeeDTO) throws SQLException;
    void delete(Long id) throws SQLException;
}