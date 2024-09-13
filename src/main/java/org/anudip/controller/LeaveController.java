package org.anudip.controller;

import org.anudip.model.Leave;
import org.anudip.service.LeaveService;

import java.util.List;
import java.util.Scanner;

public class LeaveController {
    private static final Scanner scanner = new Scanner(System.in);
    private LeaveService leaveService;

    public LeaveController() {
        this.leaveService = new LeaveService();
    }

    public void leaveMenu() {
        while (true) {
            System.out.println("=======================================================");
            System.out.println("Leave Menu:");
            System.out.println("1. Add Leave");
            System.out.println("2. Delete Leave");
            System.out.println("3. Update Leave");
            System.out.println("4. Select Leave");
            System.out.println("5. List All Leaves");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose an option: ");
            System.out.println("=======================================================");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addLeave();
                    break;
                case 2:
                    deleteLeave();
                    break;
                case 3:
                    updateLeave();
                    break;
                case 4:
                    selectLeave();
                    break;
                case 5:
                    listAllLeaves();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addLeave() {
        Leave leave = new Leave();
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();
        leave.setEmployeeId(employeeId);
        System.out.print("Enter Leave Type: ");
        String leaveType = scanner.nextLine();
        leave.setLeaveType(leaveType);
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        leave.setStartDate(java.sql.Date.valueOf(startDateStr));
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();
        leave.setEndDate(java.sql.Date.valueOf(endDateStr));

        leaveService.addLeave(leave);
        System.out.println("Leave added successfully.");
    }

    private void deleteLeave() {
        System.out.print("Enter Leave ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        leaveService.deleteLeave(id);
        System.out.println("Leave deleted successfully.");
    }

    private void updateLeave() {
        System.out.print("Enter Leave ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Leave leave = leaveService.getLeave(id);

        if (leave != null) {
            System.out.print("Enter new Employee ID (leave blank to keep current): ");
            String employeeIdStr = scanner.nextLine();
            if (!employeeIdStr.isEmpty()) {
                leave.setEmployeeId(Integer.parseInt(employeeIdStr));
            }
            System.out.print("Enter new Leave Type (leave blank to keep current): ");
            String leaveType = scanner.nextLine();
            if (!leaveType.isEmpty()) {
                leave.setLeaveType(leaveType);
            }
            System.out.print("Enter new Start Date (YYYY-MM-DD) (leave blank to keep current): ");
            String startDateStr = scanner.nextLine();
            if (!startDateStr.isEmpty()) {
                leave.setStartDate(java.sql.Date.valueOf(startDateStr));
            }
            System.out.print("Enter new End Date (YYYY-MM-DD) (leave blank to keep current): ");
            String endDateStr = scanner.nextLine();
            if (!endDateStr.isEmpty()) {
                leave.setEndDate(java.sql.Date.valueOf(endDateStr));
            }

            leaveService.updateLeave(leave);
            System.out.println("Leave updated successfully.");
        } else {
            System.out.println("Leave not found.");
        }
    }

    private void selectLeave() {
        System.out.print("Enter Leave ID to select: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Leave leave = leaveService.getLeave(id);

        if (leave != null) {
            System.out.println(leave);
        } else {
            System.out.println("Leave not found.");
        }
    }

    private void listAllLeaves() {
        List<Leave> leaves = leaveService.getAllLeaves();
        for (Leave leave : leaves) {
            System.out.println(leave);
        }
    }
}
