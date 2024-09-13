package org.anudip.controller;

import org.anudip.model.Department;
import org.anudip.service.DepartmentService;

import java.util.List;
import java.util.Scanner;

public class DepartmentController {
    private static final Scanner scanner = new Scanner(System.in);
    private DepartmentService departmentService;

    public DepartmentController() {
        this.departmentService = new DepartmentService();
    }

    public void departmentMenu() {
        while (true) {
        	System.out.println("=======================================================");
            System.out.println("Department Menu:");
            System.out.println("1. Add Department");
            System.out.println("2. Delete Department");
            System.out.println("3. Update Department");
            System.out.println("4. Select Department");
            System.out.println("5. List All Departments");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose an option: ");
            System.out.println("====================================================================");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    deleteDepartment();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    selectDepartment();
                    break;
                case 5:
                    listAllDepartments();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addDepartment() {
        Department department = new Department();
        System.out.print("Enter Department Name: ");
        String name = scanner.nextLine();
        department.setDepartmentName(name);
        System.out.print("Enter Location: ");
        String location = scanner.nextLine();
        department.setLocation(location);

        departmentService.addDepartment(department);
        System.out.println("=======================================================");
        System.out.println("Department added successfully.");
        System.out.println("=======================================================");
    }

    private void deleteDepartment() {
        System.out.print("Enter Department ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        departmentService.deleteDepartment(id);
        System.out.println("=======================================================");
        System.out.println("Department deleted successfully.");
        System.out.println("=======================================================");
    }

    private void updateDepartment() {
        System.out.print("Enter Department ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Department department = departmentService.getDepartment(id);

        if (department != null) {
            System.out.print("Enter new Department Name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                department.setDepartmentName(name);
            }
            System.out.print("Enter new Location (leave blank to keep current): ");
            String location = scanner.nextLine();
            if (!location.isEmpty()) {
                department.setLocation(location);
            }

            departmentService.updateDepartment(department);
            System.out.println("=======================================================");
            System.out.println("Department updated successfully.");
            System.out.println("=======================================================");
        } else {
            System.out.println("Department not found.");
        }
    }

    private void selectDepartment() {
        System.out.print("Enter Department ID to select: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Department department = departmentService.getDepartment(id);

        if (department != null) {
        	System.out.println("=======================================================");
            System.out.println("Department ID: " + department.getDepartmentId());
            System.out.println("Department Name: " + department.getDepartmentName());
            System.out.println("Location: " + department.getLocation());
            System.out.println("=======================================================");
        } else {
            System.out.println("Department not found.");
        }
    }

    private void listAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        for (Department department : departments) {
        	System.out.println("=======================================================");
            System.out.println("Department ID: " + department.getDepartmentId());
            System.out.println("Department Name: " + department.getDepartmentName());
            System.out.println("Location: " + department.getLocation());
            System.out.println("=======================================================");
        }
    }
}
