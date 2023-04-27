package com.example.demojdbc.constant;

public class SqlConstant {
    public static final String INSERT_EMPLOYEE = "INSERT INTO employees (id, name, age, email) VALUES (?,?,?,?)";
    public static final String GET_ALL_EMPLOYEES = "SELECT * FROM employees";
    public static final String UPDATE_EMPLOYEE = "UPDATE employees SET name = ?, age = ?, email = ? WHERE id = ?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM employees WHERE id = ?";
}