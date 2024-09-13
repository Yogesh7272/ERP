package org.anudip.controller;

import org.anudip.model.Project;
import org.anudip.model.Client;
import org.anudip.service.ProjectService;
import org.anudip.service.ClientService;

import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class ProjectController {
    private static final Scanner scanner = new Scanner(System.in);
    private ProjectService projectService;
    private ClientService clientService;

    public ProjectController() {
        this.projectService = new ProjectService();
        this.clientService = new ClientService();
    }

    public void projectMenu() {
        while (true) {
            System.out.println("=======================================================");
            System.out.println("Project Menu:");
            System.out.println("1. Add Project");
            System.out.println("2. Delete Project");
            System.out.println("3. Update Project");
            System.out.println("4. Select Project");
            System.out.println("5. List All Projects");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose an option: ");
            System.out.println("=======================================================");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addProject();
                    break;
                case 2:
                    deleteProject();
                    break;
                case 3:
                    updateProject();
                    break;
                case 4:
                    selectProject();
                    break;
                case 5:
                    listAllProjects();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProject() {
        Project project = new Project();

        int projectId = 0;
        while (true) {
            System.out.print("Enter Project ID (integer only): ");
            if (scanner.hasNextInt()) {
                projectId = scanner.nextInt();
                scanner.nextLine(); // consume newline
                break; // valid input, break the loop
            } else {
                System.out.println("Invalid input! Please enter a valid integer for Project ID.");
                scanner.nextLine(); // clear the invalid input
            }
        }
        project.setProjectId(projectId);

        System.out.print("Enter Project Name: ");
        String projectName = scanner.nextLine();
        project.setProjectName(projectName);

        System.out.print("Enter Client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Client client = clientService.getClient(clientId);
        if (client == null) {
            System.out.println("Invalid Client ID. Please try again.");
            return;
        }
        project.setClient(client);

        System.out.print("Enter Project Deadline (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        Date deadline = java.sql.Date.valueOf(dateInput);
        project.setDeadline(deadline);

        projectService.addProject(project);
        System.out.println("Project added successfully.");
    }


    private void deleteProject() {
        System.out.print("Enter Project ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        projectService.deleteProject(id);
        System.out.println("Project deleted successfully.");
    }

    private void updateProject() {
        System.out.print("Enter Project ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Project project = projectService.getProject(id);

        if (project != null) {
            System.out.print("Enter new Project Name (leave blank to keep current): ");
            String projectName = scanner.nextLine();
            if (!projectName.isEmpty()) {
                project.setProjectName(projectName);
            }

            System.out.print("Enter new Client ID (leave blank to keep current): ");
            String clientInput = scanner.nextLine();
            if (!clientInput.isEmpty()) {
                int clientId = Integer.parseInt(clientInput);
                Client client = clientService.getClient(clientId);
                if (client != null) {
                    project.setClient(client);
                } else {
                    System.out.println("Invalid Client ID.");
                }
            }

            System.out.print("Enter new Project Deadline (leave blank to keep current): ");
            String dateInput = scanner.nextLine();
            if (!dateInput.isEmpty()) {
                Date deadline = java.sql.Date.valueOf(dateInput);
                project.setDeadline(deadline);
            }

            projectService.updateProject(project);
            System.out.println("Project updated successfully.");
        } else {
            System.out.println("Project not found.");
        }
    }

    private void selectProject() {
        System.out.print("Enter Project ID to select: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Project project = projectService.getProject(id);

        if (project != null) {
            System.out.println("Project ID: " + project.getProjectId());
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Client: " + project.getClient().getClientName());
            System.out.println("Deadline: " + project.getDeadline());
        } else {
            System.out.println("Project not found.");
        }
    }

    private void listAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        for (Project project : projects) {
            System.out.println("Project ID: " + project.getProjectId());
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Client: " + project.getClient().getClientName());
            System.out.println("Deadline: " + project.getDeadline());
            System.out.println("-----");
        }
    }
}
