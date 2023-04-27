package com.example.demojdbc.service.impl;

import com.example.demojdbc.dao.EmployeeJdbcApiDAO;
import com.example.demojdbc.dto.EmployeeDTO;
import com.example.demojdbc.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class JdbcApiServiceImpl implements EmployeeService {
    private final EmployeeJdbcApiDAO employeeJdbcApiDAO;

    public JdbcApiServiceImpl(EmployeeJdbcApiDAO employeeJdbcApiDAO) {
        this.employeeJdbcApiDAO = employeeJdbcApiDAO;
    }

    @Override
    public int createEmployee(EmployeeDTO request) throws SQLException {
        return employeeJdbcApiDAO.createEmployee(request);
    }

    @Override
    public List<EmployeeDTO> getAll() throws SQLException {
        return employeeJdbcApiDAO.getAll();
    }

    @Override
    public int updateEmployee(Long id, EmployeeDTO employeeDTO) throws SQLException {
        return employeeJdbcApiDAO.updateEmployee(id, employeeDTO);
    }

    @Override
    public void delete(Long id) throws SQLException {
        employeeJdbcApiDAO.delete(id);
    }
}
