package org.anudip.controller;

import org.anudip.model.Client;
import org.anudip.service.ClientService;

import java.util.List;
import java.util.Scanner;

public class ClientController {
    private static final Scanner scanner = new Scanner(System.in);
    private ClientService clientService;

    public ClientController() {
        this.clientService = new ClientService();
    }

    public void clientMenu() {
        while (true) {
        	System.out.println("=======================================================");
            System.out.println("Client Menu:");
            System.out.println("1. Add Client");
            System.out.println("2. Delete Client");
            System.out.println("3. Update Client");
            System.out.println("4. Select Client");
            System.out.println("5. List All Clients");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose an option: ");
            
            System.out.println("=======================================================");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addClient();
                    break;
                case 2:
                    deleteClient();
                    break;
                case 3:
                    updateClient();
                    break;
                case 4:
                    selectClient();
                    break;
                case 5:
                    listAllClients();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addClient() {
        Client client = new Client();
        System.out.print("Enter Client Name: ");
        String name = scanner.nextLine();
        client.setClientName(name);
        System.out.print("Enter Industry: ");
        String industry = scanner.nextLine();
        client.setIndustry(industry);
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();
        client.setContactInfo(contactInfo);

        clientService.addClient(client);
        System.out.println("Client added successfully.");
    }

    private void deleteClient() {
        System.out.print("Enter Client ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        clientService.deleteClient(id);
        System.out.println("Client deleted successfully.");
    }

    private void updateClient() {
        System.out.print("Enter Client ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Client client = clientService.getClient(id);

        if (client != null) {
            System.out.print("Enter new Client Name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                client.setClientName(name);
            }
            System.out.print("Enter new Industry (leave blank to keep current): ");
            String industry = scanner.nextLine();
            if (!industry.isEmpty()) {
                client.setIndustry(industry);
            }
            System.out.print("Enter new Contact Info (leave blank to keep current): ");
            String contactInfo = scanner.nextLine();
            if (!contactInfo.isEmpty()) {
                client.setContactInfo(contactInfo);
            }

            clientService.updateClient(client);
            System.out.println("Client updated successfully.");
        } else {
            System.out.println("Client not found.");
        }
    }

    private void selectClient() {
        System.out.print("Enter Client ID to select: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Client client = clientService.getClient(id);

        if (client != null) {
            System.out.println("Client ID: " + client.getClientId());
            System.out.println("Name: " + client.getClientName());
            System.out.println("Industry: " + client.getIndustry());
            System.out.println("Contact Info: " + client.getContactInfo());
        } else {
            System.out.println("Client not found.");
        }
    }

    private void listAllClients() {
        List<Client> clients = clientService.getAllClients();
        for (Client client : clients) {
            System.out.println("Client ID: " + client.getClientId());
            System.out.println("Name: " + client.getClientName());
            System.out.println("Industry: " + client.getIndustry());
            System.out.println("Contact Info: " + client.getContactInfo());
            System.out.println("-----");
        }
    }
}
