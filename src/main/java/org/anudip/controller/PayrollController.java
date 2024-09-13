package org.anudip.controller;

import org.anudip.model.Payroll;
import org.anudip.service.PayrollService;

import java.util.List;
import java.util.Scanner;

public class PayrollController {
    private static final Scanner scanner = new Scanner(System.in);
    private PayrollService payrollService;

    public PayrollController() {
        this.payrollService = new PayrollService();
    }

    public void payrollMenu() {
        while (true) {
            System.out.println("Payroll Menu:");
            System.out.println("1. Add Payroll");
            System.out.println("2. Delete Payroll");
            System.out.println("3. Update Payroll");
            System.out.println("4. Select Payroll");
            System.out.println("5. List All Payrolls");
            System.out.println("6. Back to Admin Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPayroll();
                    break;
                case 2:
                    deletePayroll();
                    break;
                case 3:
                    updatePayroll();
                    break;
                case 4:
                    selectPayroll();
                    break;
                case 5:
                    listAllPayrolls();
                    break;
                case 6:
                    return; // Go back to Admin Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addPayroll() {
        Payroll payroll = new Payroll();
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();
        payroll.setEmployeeId(employeeId);
        System.out.print("Enter Base Salary: ");
        double baseSalary = scanner.nextDouble();
        scanner.nextLine();
        payroll.setBaseSalary(baseSalary);
        System.out.print("Enter Deductions: ");
        double deductions = scanner.nextDouble();
        scanner.nextLine();
        payroll.setDeductions(deductions);
        payroll.setNetSalary(baseSalary - deductions);

        payrollService.addPayroll(payroll);
        System.out.println("Payroll added successfully.");
    }

    private void deletePayroll() {
        System.out.print("Enter Payroll ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        payrollService.deletePayroll(id);
        System.out.println("Payroll deleted successfully.");
    }

    private void updatePayroll() {
        System.out.print("Enter Payroll ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Payroll payroll = payrollService.getPayroll(id);

        if (payroll != null) {
            System.out.print("Enter new Base Salary (leave blank to keep current): ");
            String baseSalaryInput = scanner.nextLine();
            if (!baseSalaryInput.isEmpty()) {
                double baseSalary = Double.parseDouble(baseSalaryInput);
                payroll.setBaseSalary(baseSalary);
                payroll.setNetSalary(baseSalary - payroll.getDeductions());
            }
            System.out.print("Enter new Deductions (leave blank to keep current): ");
            String deductionsInput = scanner.nextLine();
            if (!deductionsInput.isEmpty()) {
                double deductions = Double.parseDouble(deductionsInput);
                payroll.setDeductions(deductions);
                payroll.setNetSalary(payroll.getBaseSalary() - deductions);
            }

            payrollService.updatePayroll(payroll);
            System.out.println("Payroll updated successfully.");
        } else {
            System.out.println("Payroll not found.");
        }
    }

    private void selectPayroll() {
        System.out.print("Enter Payroll ID to select: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Payroll payroll = payrollService.getPayroll(id);

        if (payroll != null) {
            System.out.println("Payroll ID: " + payroll.getPayrollId());
            System.out.println("Employee ID: " + payroll.getEmployeeId());
            System.out.println("Base Salary: " + payroll.getBaseSalary());
            System.out.println("Deductions: " + payroll.getDeductions());
            System.out.println("Net Salary: " + payroll.getNetSalary());
        } else {
            System.out.println("Payroll not found.");
        }
    }

    private void listAllPayrolls() {
        List<Payroll> payrolls = payrollService.getAllPayrolls();
        for (Payroll payroll : payrolls) {
        	System.out.println("====================================================");
            System.out.println("Payroll ID: " + payroll.getPayrollId());
            System.out.println("Employee ID: " + payroll.getEmployeeId());
            System.out.println("Base Salary: " + payroll.getBaseSalary());
            System.out.println("Deductions: " + payroll.getDeductions());
            System.out.println("Net Salary: " + payroll.getNetSalary());
            System.out.println("====================================================");
        }
    }
}
