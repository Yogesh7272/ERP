package org.anudip.controller;

import org.anudip.model.Employee;
import org.anudip.model.Department;
import org.anudip.service.EmployeeService;
import org.anudip.service.DepartmentService;

import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class EmployeeController {
    private static final Scanner scanner = new Scanner(System.in);
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
        this.departmentService = new DepartmentService();
    }

    public void employeeMenu() {
        while (true) {
        	System.out.println("=======================================================");
            System.out.println("Employee Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Select Employee");
            System.out.println("5. List All Employees");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose an option: ");
            System.out.println("=======================================================");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    selectEmployee();
                    break;
                case 5:
                    listAllEmployees();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addEmployee() {
        Employee employee = new Employee();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        employee.setName(name);

        System.out.print("Enter Department ID: ");
        int departmentId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Department department = departmentService.getDepartment(departmentId);
        if (department == null) {
            System.out.println("Invalid Department ID. Please try again.");
            return;
        }
        employee.setDepartment(department);

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        employee.setSalary(salary);

        System.out.print("Enter Joining Date (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        Date joiningDate = java.sql.Date.valueOf(dateInput);
        employee.setJoiningDate(joiningDate);

        employeeService.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        employeeService.deleteEmployee(id);
        System.out.println("Employee deleted successfully.");
    }

    private void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Employee employee = employeeService.getEmployee(id);

        if (employee != null) {
            System.out.print("Enter new Employee Name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                employee.setName(name);
            }

            System.out.print("Enter new Department ID (leave blank to keep current): ");
            String departmentInput = scanner.nextLine();
            if (!departmentInput.isEmpty()) {
                int departmentId = Integer.parseInt(departmentInput);
                Department department = departmentService.getDepartment(departmentId);
                if (department != null) {
                    employee.setDepartment(department);
                } else {
                    System.out.println("Invalid Department ID.");
                }
            }

            System.out.print("Enter new Salary (leave blank to keep current): ");
            String salaryInput = scanner.nextLine();
            if (!salaryInput.isEmpty()) {
                double salary = Double.parseDouble(salaryInput);
                employee.setSalary(salary);
            }

            System.out.print("Enter new Joining Date (leave blank to keep current): ");
            String dateInput = scanner.nextLine();
            if (!dateInput.isEmpty()) {
                Date joiningDate = java.sql.Date.valueOf(dateInput);
                employee.setJoiningDate(joiningDate);
            }

            employeeService.updateEmployee(employee);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private void selectEmployee() {
        System.out.print("Enter Employee ID to select: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Employee employee = employeeService.getEmployee(id);

        if (employee != null) {
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment().getDepartmentName());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Joining Date: " + employee.getJoiningDate());
        } else {
            System.out.println("Employee not found.");
        }
    }

    private void listAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment().getDepartmentName());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Joining Date: " + employee.getJoiningDate());
            System.out.println("-----");
        }
    }
}
