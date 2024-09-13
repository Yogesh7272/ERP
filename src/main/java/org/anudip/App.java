package org.anudip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.anudip.controller.AdminController;
import org.anudip.controller.ClientControllerInfo;
import org.anudip.controller.DepartmentController;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static AdminController adminController = new AdminController();
    private static DepartmentController departmentController = new DepartmentController();

    // Data for authentication
    private static Map<String, String> adminCredentials = new HashMap<>();
    private static Map<String, String> clientCredentials = new HashMap<>();

    static {
        // Initialize with some test credentials
        adminCredentials.put("anp11", "anudip123");
        clientCredentials.put("client11", "client123");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the ERP System");
            System.out.println("1. Admin Login");
            System.out.println("2. Client Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    clientLogin();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminLogin() {
        System.out.print("Enter Admin ID: ");
        String adminId = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String adminPassword = scanner.nextLine();

        if (adminCredentials.containsKey(adminId) && adminCredentials.get(adminId).equals(adminPassword)) {
        	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Admin logged in successfully.");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            AdminController.adminMenu();
        } else {
        	System.out.println("=======================================================");
            System.out.println("Invalid Admin ID or Password.");
            System.out.println("=======================================================");
        }
    }

    private static void clientLogin() {
        System.out.print("Enter Client ID: ");
        String clientId = scanner.nextLine();
        System.out.print("Enter Client Password: ");
        String clientPassword = scanner.nextLine();

        if (clientCredentials.containsKey(clientId) && clientCredentials.get(clientId).equals(clientPassword)) {
        	System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("Client logged in successfully.");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            ClientControllerInfo.clientMenu();
        } else {
        	System.out.println("=======================================================");
            System.out.println("Invalid Client ID or Password.");
            System.out.println("=======================================================");
        }
    }
}
