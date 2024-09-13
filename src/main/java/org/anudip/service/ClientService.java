package org.anudip.service;

import org.anudip.dao.ClientDao;
import org.anudip.model.Client;

import java.util.List;

public class ClientService {
    private ClientDao clientDao;

    public ClientService() {
        this.clientDao = new ClientDao();
    }

    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    public void deleteClient(int id) {
        clientDao.deleteClient(id);
    }

    public Client getClient(int id) {
        return clientDao.getClient(id);
    }

    public void updateClient(Client client) {
        clientDao.updateClient(client);
    }

    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }
}
