public class Main {
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        crud.addEmployee(new Employee(1, "John Doe", "IT"));
        crud.addEmployee(new Employee(2, "Jane Doe", "HR"));
        System.out.println("Total No. Employees: " + crud.getEmployees().size());
        for (Employee emp : crud.getEmployees()) {
            System.out.println("Employee: " + emp.getName() + ", Department: " + emp.getDepartment());
        }
        Employee employee = crud.getEmployee(1);
        System.out.println("Employee 1: " + employee.getName());

        crud.updateEmployee(1, "John Smith", "Finance");
        System.out.println("Updated info of employee 1: " + crud.getEmployee(1).getName() + ", " + crud.getEmployee(1).getDepartment());
        crud.deleteEmployee(2);
        System.out.println("Total No. Employees: " + crud.getEmployees().size());
        for (Employee emp : crud.getEmployees()) {
            System.out.println("Employee: " + emp.getName() + ", Department: " + emp.getDepartment());
        }
    }

}