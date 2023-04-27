package com.example.demojdbc.service.impl;

import com.example.demojdbc.dao.EmployeeJdbcTemplateDAO;
import com.example.demojdbc.dto.EmployeeDTO;
import com.example.demojdbc.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class JdbcTemplateServiceImpl implements EmployeeService {
    private final EmployeeJdbcTemplateDAO employeeJdbcTemplateDAO;

    public JdbcTemplateServiceImpl(EmployeeJdbcTemplateDAO employeeJdbcTemplateDAO) {
        this.employeeJdbcTemplateDAO = employeeJdbcTemplateDAO;
    }

    @Override
    public int createEmployee(EmployeeDTO request) throws SQLException {
        return employeeJdbcTemplateDAO.create(request);
    }

    @Override
    public List<EmployeeDTO> getAll() throws SQLException {
        return employeeJdbcTemplateDAO.getAll();
    }

    @Override
    public int updateEmployee(Long id, EmployeeDTO employeeDTO) throws SQLException {
        return employeeJdbcTemplateDAO.update(id, employeeDTO);
    }

    @Override
    public void delete(Long id) throws SQLException {
        employeeJdbcTemplateDAO.delete(id);
    }
}