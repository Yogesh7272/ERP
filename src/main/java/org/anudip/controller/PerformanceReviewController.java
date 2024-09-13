package org.anudip.controller;

import org.anudip.model.PerformanceReview;
import org.anudip.service.PerformanceReviewService;

import java.util.List;
import java.util.Scanner;

public class PerformanceReviewController {
    private static final Scanner scanner = new Scanner(System.in);
    private PerformanceReviewService performanceReviewService;

    public PerformanceReviewController() {
        this.performanceReviewService = new PerformanceReviewService();
    }

    public void performanceReviewMenu() {
        while (true) {
            System.out.println("=======================================================");
            System.out.println("Performance Review Menu:");
            System.out.println("1. Add Performance Review");
            System.out.println("2. Delete Performance Review");
            System.out.println("3. Update Performance Review");
            System.out.println("4. Select Performance Review");
            System.out.println("5. List All Performance Reviews");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose an option: ");
            System.out.println("=======================================================");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPerformanceReview();
                    break;
                case 2:
                    deletePerformanceReview();
                    break;
                case 3:
                    updatePerformanceReview();
                    break;
                case 4:
                    selectPerformanceReview();
                    break;
                case 5:
                    listAllPerformanceReviews();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addPerformanceReview() {
        PerformanceReview performanceReview = new PerformanceReview();
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();
        performanceReview.setEmployeeId(employeeId);
        System.out.print("Enter Reviewer Name: ");
        String reviewer = scanner.nextLine();
        performanceReview.setReviewer(reviewer);
        System.out.print("Enter Review Date (YYYY-MM-DD): ");
        String reviewDateStr = scanner.nextLine();
        performanceReview.setReviewDate(java.sql.Date.valueOf(reviewDateStr));
        System.out.print("Enter Performance Score: ");
        int score = scanner.nextInt();
        scanner.nextLine();
        performanceReview.setPerformanceScore(score);

        performanceReviewService.addPerformanceReview(performanceReview);
        System.out.println("=======================================================");
        System.out.println("Performance Review added successfully.");
        System.out.println("=======================================================");
    }

    private void deletePerformanceReview() {
        System.out.print("Enter Performance Review ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        performanceReviewService.deletePerformanceReview(id);
        System.out.println("=======================================================");
        System.out.println("Performance Review deleted successfully.");
        System.out.println("=======================================================");
    }

    private void updatePerformanceReview() {
        System.out.print("Enter Performance Review ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        PerformanceReview performanceReview = performanceReviewService.getPerformanceReview(id);

        if (performanceReview != null) {
            System.out.print("Enter new Employee ID (leave blank to keep current): ");
            String employeeIdStr = scanner.nextLine();
            if (!employeeIdStr.isEmpty()) {
                performanceReview.setEmployeeId(Integer.parseInt(employeeIdStr));
            }
            System.out.print("Enter new Reviewer Name (leave blank to keep current): ");
            String reviewer = scanner.nextLine();
            if (!reviewer.isEmpty()) {
                performanceReview.setReviewer(reviewer);
            }
            System.out.print("Enter new Review Date (leave blank to keep current, format YYYY-MM-DD): ");
            String reviewDateStr = scanner.nextLine();
            if (!reviewDateStr.isEmpty()) {
                performanceReview.setReviewDate(java.sql.Date.valueOf(reviewDateStr));
            }
            System.out.print("Enter new Performance Score (leave blank to keep current): ");
            String scoreStr = scanner.nextLine();
            if (!scoreStr.isEmpty()) {
                performanceReview.setPerformanceScore(Integer.parseInt(scoreStr));
            }

            performanceReviewService.updatePerformanceReview(performanceReview);
            System.out.println("=======================================================");
            System.out.println("Performance Review updated successfully.");
            System.out.println("=======================================================");
        } else {
            System.out.println("Performance Review not found.");
        }
    }

    private void selectPerformanceReview() {
        System.out.print("Enter Performance Review ID to select: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        PerformanceReview performanceReview = performanceReviewService.getPerformanceReview(id);

        if (performanceReview != null) {
            System.out.println("=======================================================");
            System.out.println(performanceReview);
            System.out.println("=======================================================");
        } else {
            System.out.println("Performance Review not found.");
        }
    }

    private void listAllPerformanceReviews() {
        List<PerformanceReview> performanceReviews = performanceReviewService.getAllPerformanceReviews();
        for (PerformanceReview performanceReview : performanceReviews) {
            System.out.println("=======================================================");
            System.out.println(performanceReview);
            System.out.println("=======================================================");
        }
    }
}
