package org.anudip.controller;

import org.anudip.model.*;
import org.anudip.service.*;

import java.util.List;
import java.util.Scanner;

public class AdminController {
    private static final Scanner scanner = new Scanner(System.in);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static ClientService clientService;
    private static ProjectService projectService;
    private static AttendanceService attendanceService;
    private static LeaveService leaveService;
    private static PayrollService payrollService;
    private static PerformanceReviewService reviewService;
    private static AssetService assetService;

    public AdminController() {
        this.employeeService = new EmployeeService();
        this.departmentService = new DepartmentService();
        this.clientService = new ClientService();
        this.projectService = new ProjectService();
        this.attendanceService = new AttendanceService();
        this.leaveService = new LeaveService();
        this.payrollService = new PayrollService();
        this.reviewService = new PerformanceReviewService();
        this.assetService = new AssetService();
    }

    public static void adminMenu() {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Manage Department");
            System.out.println("2. Manage Client");
            System.out.println("3. Manage Employee");
            System.out.println("4. Manage Project");
            System.out.println("5. Manage Attendance");
            System.out.println("6. Manage Leave");
            System.out.println("7. Manage Payroll");
            System.out.println("8. Manage Performance Review");
            System.out.println("9. Manage Asset");
            System.out.println("10. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                   DepartmentController obj = new DepartmentController();
                   obj.departmentMenu();
                   break;
                case 2:
                	ClientController obj1 = new ClientController();
                    obj1.clientMenu();
                    break;
                case 3:
                	EmployeeController obj2 = new EmployeeController();
                    obj2.employeeMenu();
                    break;
                case 4:
                    ProjectController obj3 = new ProjectController();
                    obj3.projectMenu();
                    break;
                case 5:
                    AttendanceController obj4 = new AttendanceController();
                    obj4.attendanceMenu();
                    break;
                case 6:
                   LeaveController obj5 = new LeaveController();
                   obj5.leaveMenu();
                    break;
                case 7:
                   PayrollController obj6 = new PayrollController();
                   obj6.payrollMenu();
                    break;
                case 8:
                   PerformanceReviewController obj7 = new PerformanceReviewController();
                   obj7.performanceReviewMenu();
                    break;
                case 9:
                    manageAsset();
                    break;
                case 10:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    
    
    // Client Management
    private static void manageClient() {
        // Implement similar logic for the Client menu
    }

    // Employee Management
    private static void manageEmployee() {
        while (true) {
            System.out.println("Employee Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Select Employee");
            System.out.println("5. List All Employees");
            System.out.println("6. Back to Admin Menu");
            System.out.print("Choose an option: ");
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
                    return; // Go back to Admin Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        // Implement logic to add an employee
    }

    private static void deleteEmployee() {
        // Implement logic to delete an employee
    }

    private static void updateEmployee() {
        // Implement logic to update an employee
    }

    private static void selectEmployee() {
        // Implement logic to select an employee
    }

    private static void listAllEmployees() {
        // Implement logic to list all employees
    }

    // Project Management
    private static void manageProject() {
        // Implement similar logic for the Project menu
    }

    // Attendance Management
    private static void manageAttendance() {
        // Implement similar logic for the Attendance menu
    }

    // Leave Management
    private static void manageLeave() {
        // Implement similar logic for the Leave menu
    }

    // Payroll Management
    private static void managePayroll() {
        // Implement similar logic for the Payroll menu
    }

    // Performance Review Management
    private static void managePerformanceReview() {
        // Implement similar logic for the Performance Review menu
    }

    // Asset Management
    private static void manageAsset() {
        // Implement similar logic for the Asset menu
    }
}
