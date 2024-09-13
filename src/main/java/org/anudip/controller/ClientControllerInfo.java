package org.anudip.controller;

import java.util.Scanner;

import org.anudip.model.Payroll;
import org.anudip.model.Client;
import org.anudip.service.ClientService;
import org.anudip.service.PayrollService;

public class ClientControllerInfo {
    private static final Scanner scanner = new Scanner(System.in);
    private static ClientService clientService = new ClientService();
    private static PayrollService payrollService = new PayrollService();

    public static void clientMenu() {
        while (true) {
            System.out.println("Client Menu:");
            System.out.println("1. View Profile");
            System.out.println("2. View Salary");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewProfile();
                    break;
                case 2:
                    viewSalary();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return; // Exit the client menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewProfile() {
        System.out.print("Enter Client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Fetch and display client profile information
        Client client = clientService.getClient(clientId);
        if (client != null) {
            System.out.println("Client Name: " + client.getClientName());
            System.out.println("Industry: " + client.getIndustry());
            System.out.println("Contact Info: " + client.getContactInfo());
        } else {
            System.out.println("Client not found.");
        }
    }

    private static void viewSalary() {
        System.out.print("Enter Client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Fetch client profile to get employeeId
        Client client = clientService.getClient(clientId);
        if (client != null) {
            int employeeId = getEmployeeIdForClient(clientId); // Method to get employeeId

            // Fetch and display payroll information
            Payroll payroll = payrollService.getPayroll(employeeId);
            if (payroll != null) {
                System.out.println("Base Salary: " + payroll.getBaseSalary());
                System.out.println("Deductions: " + payroll.getDeductions());
                System.out.println("Net Salary: " + payroll.getNetSalary());
            } else {
                System.out.println("Payroll information not found.");
            }
        } else {
            System.out.println("Client not found.");
        }
    }

    // Method to fetch employeeId for a given clientId
    private static int getEmployeeIdForClient(int clientId) {
        return 1; // Return actual employeeId for the given clientId
    }
}
