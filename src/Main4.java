import java.sql.SQLException;

public class Main4 {
    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();
        try {
            Employee newEmployee = new Employee(1, "John Doe", "IT");
            employeeJDBC.addEmployee(newEmployee);
            Employee employee = employeeJDBC.getEmployee(1);
            System.out.println(employee.getName());
            employee.setName("Jane Doe");
            employeeJDBC.updateEmployee(employee);
            employeeJDBC.deleteEmployee(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
