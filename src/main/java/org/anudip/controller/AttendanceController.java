package org.anudip.controller;

import org.anudip.model.Attendance;
import org.anudip.service.AttendanceService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AttendanceController {
    private static final Scanner scanner = new Scanner(System.in);
    private AttendanceService attendanceService;

    public AttendanceController() {
        this.attendanceService = new AttendanceService();
    }

    public void attendanceMenu() {
        while (true) {
            System.out.println("=======================================================");
            System.out.println("Attendance Menu:");
            System.out.println("1. Add Attendance");
            System.out.println("2. Delete Attendance");
            System.out.println("3. Update Attendance");
            System.out.println("4. Select Attendance");
            System.out.println("5. List All Attendances");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose an option: ");
            System.out.println("=======================================================");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAttendance();
                    break;
                case 2:
                    deleteAttendance();
                    break;
                case 3:
                    updateAttendance();
                    break;
                case 4:
                    selectAttendance();
                    break;
                case 5:
                    listAllAttendances();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addAttendance() {
        Attendance attendance = new Attendance();
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();
        attendance.setEmployeeId(employeeId);
        System.out.print("Enter Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        attendance.setDate(date);
        System.out.print("Enter Check-in Time (HH:MM): ");
        LocalTime checkInTime = LocalTime.parse(scanner.nextLine());
        attendance.setCheckInTime(checkInTime);
        System.out.print("Enter Check-out Time (HH:MM): ");
        LocalTime checkOutTime = LocalTime.parse(scanner.nextLine());
        attendance.setCheckOutTime(checkOutTime);

        attendanceService.addAttendance(attendance);
        System.out.println("Attendance added successfully.");
    }

    private void deleteAttendance() {
        System.out.print("Enter Attendance ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        attendanceService.deleteAttendance(id);
        System.out.println("Attendance deleted successfully.");
    }

    private void updateAttendance() {
        System.out.print("Enter Attendance ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Attendance attendance = attendanceService.getAttendance(id);

        if (attendance != null) {
            System.out.print("Enter new Employee ID (leave blank to keep current): ");
            String empId = scanner.nextLine();
            if (!empId.isEmpty()) {
                attendance.setEmployeeId(Integer.parseInt(empId));
            }
            System.out.print("Enter new Date (leave blank to keep current): ");
            String date = scanner.nextLine();
            if (!date.isEmpty()) {
                attendance.setDate(LocalDate.parse(date));
            }
            System.out.print("Enter new Check-in Time (leave blank to keep current): ");
            String checkInTime = scanner.nextLine();
            if (!checkInTime.isEmpty()) {
                attendance.setCheckInTime(LocalTime.parse(checkInTime));
            }
            System.out.print("Enter new Check-out Time (leave blank to keep current): ");
            String checkOutTime = scanner.nextLine();
            if (!checkOutTime.isEmpty()) {
                attendance.setCheckOutTime(LocalTime.parse(checkOutTime));
            }

            attendanceService.updateAttendance(attendance);
            System.out.println("Attendance updated successfully.");
        } else {
            System.out.println("Attendance not found.");
        }
    }

    private void selectAttendance() {
        System.out.print("Enter Attendance ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Attendance attendance = attendanceService.getAttendance(id);

        if (attendance != null) {
            System.out.println("Attendance ID: " + attendance.getAttendanceId());
            System.out.println("Employee ID: " + attendance.getEmployeeId());
            System.out.println("Date: " + attendance.getDate());
            System.out.println("Check-in Time: " + attendance.getCheckInTime());
            System.out.println("Check-out Time: " + attendance.getCheckOutTime());
        } else {
            System.out.println("Attendance not found.");
        }
    }

    private void listAllAttendances() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        if (attendances.isEmpty()) {
            System.out.println("No attendances found.");
        } else {
            for (Attendance attendance : attendances) {
                System.out.println(attendance);
            }
        }
    }
}
