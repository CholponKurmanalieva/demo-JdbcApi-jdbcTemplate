package com.example.demojdbc.dao;

import com.example.demojdbc.constant.SqlConstant;
import com.example.demojdbc.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeJdbcApiDAO {
    private Long idCounter = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "testing";
    private static final String PASSWORD = "root";
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int createEmployee(EmployeeDTO request) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.INSERT_EMPLOYEE);

        preparedStatement.setLong(1, idCounter);
        preparedStatement.setString(2, request.getName());
        preparedStatement.setInt(3, request.getAge());
        preparedStatement.setString(4, request.getEmail());

        idCounter++;

        return preparedStatement.executeUpdate();
    }

    public List<EmployeeDTO> getAll() throws SQLException {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(SqlConstant.GET_ALL_EMPLOYEES);

        while (resultSet.next()) {
            EmployeeDTO employeeDTO = EmployeeDTO.builder()
                    .name(resultSet.getString("name"))
                    .age(resultSet.getInt("age"))
                    .email(resultSet.getString("email"))
                    .build();

            employeeDTOS.add(employeeDTO);
        }

        return employeeDTOS;
    }

    public int updateEmployee(Long id, EmployeeDTO employeeDTO) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.UPDATE_EMPLOYEE);

        preparedStatement.setString(1, employeeDTO.getName());
        preparedStatement.setInt(2, employeeDTO.getAge());
        preparedStatement.setString(3, employeeDTO.getEmail());
        preparedStatement.setLong(4, id);

        return preparedStatement.executeUpdate();
    }

    public void delete(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.DELETE_EMPLOYEE);

        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();
    }
}