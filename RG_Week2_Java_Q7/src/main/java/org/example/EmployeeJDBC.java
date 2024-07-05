package org.example;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeJDBC {
    private Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "anis123";
        return DriverManager.getConnection(url, user, password);
    }
    public void createEmployeesTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "department VARCHAR(100)" +
                ")";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (name, department) VALUES (?, ?)";
        try (Connection conn = this.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.executeUpdate();
        }
    }
    public Employee getEmployee(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection conn = this.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
            }
        }
        return null;
    }
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setInt(3, employee.getId());
            preparedStatement.executeUpdate();
        }
    }
    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<Employee> getEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        ArrayList<Employee> employees = new ArrayList<>();
        try (Connection conn = this.connect();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
            }
        }
        return employees;
    }
}


