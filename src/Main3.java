public class Main3 {
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        crud.addEmployee(new Employee(1, "John Doe", "IT"));
        crud.addEmployee(new Employee(2, "Jane Doe", "HR"));

        Employee employee = crud.getEmployee(1);
        System.out.println("Employee: " + employee.getName());

        crud.updateEmployee(1, "John Smith", "Finance");

        crud.deleteEmployee(2);
    }
}
