package org.example;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();
        try {
            employeeJDBC.createEmployeesTable();
            Employee newEmployee = new Employee(73, "John Doe", "IT");
            employeeJDBC.addEmployee(newEmployee);
            newEmployee = new Employee(74, "Jane Doe", "HR");
            employeeJDBC.addEmployee(newEmployee);
            System.out.println("Total No. Employees: " + employeeJDBC.getEmployees().size());
            for (Employee emp : employeeJDBC.getEmployees()) {
                System.out.println("Employee: " + emp.getName() + ", Department: " + emp.getDepartment());
            }
            Employee employee = employeeJDBC.getEmployee(73);
            System.out.println("Employee 1: " + employee.getName());
            employee.setName("John Smith");
            employee.setDepartment("Finance");
            employeeJDBC.updateEmployee(employee);
            System.out.println("Updated info of employee 1: " + employeeJDBC.getEmployee(73).getName() + ", " + employeeJDBC.getEmployee(73).getDepartment());
            employeeJDBC.deleteEmployee(74);
            System.out.println("Total No. Employees: " + employeeJDBC.getEmployees().size());
            for (Employee emp : employeeJDBC.getEmployees()) {
                System.out.println("Employee: " + emp.getName() + ", Department: " + emp.getDepartment());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}