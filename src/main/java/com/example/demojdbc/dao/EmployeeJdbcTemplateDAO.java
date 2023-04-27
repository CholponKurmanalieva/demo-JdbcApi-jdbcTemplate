package com.example.demojdbc.dao;

import com.example.demojdbc.constant.SqlConstant;
import com.example.demojdbc.dto.EmployeeDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeJdbcTemplateDAO {
    private int idCounter = 1;
    private final JdbcTemplate jdbcTemplate;

    public EmployeeJdbcTemplateDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int create(EmployeeDTO employeeDTO) {
        return jdbcTemplate.update(SqlConstant.INSERT_EMPLOYEE, idCounter, employeeDTO.getName(), employeeDTO.getAge(), employeeDTO.getEmail());
    }

    public int update(Long id, EmployeeDTO employeeDTO) {
        return jdbcTemplate.update(SqlConstant.UPDATE_EMPLOYEE, employeeDTO.getName(), employeeDTO.getAge(), employeeDTO.getEmail(), id);
    }

    public List<EmployeeDTO> getAll() {
        return jdbcTemplate.query(SqlConstant.GET_ALL_EMPLOYEES, new BeanPropertyRowMapper<>(EmployeeDTO.class));
    }

    public void delete(Long id) {
        jdbcTemplate.update(SqlConstant.DELETE_EMPLOYEE, id);
    }
}