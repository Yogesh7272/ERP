package org.anudip.dao;

import org.anudip.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.anudip.HibernateUtil;

import java.util.List;

public class ClientDao {

    private SessionFactory sessionFactory;

    public ClientDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    // Insert operation
    public void addClient(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update operation
    public void updateClient(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete operation
    public void deleteClient(int clientId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, clientId);
            if (client != null) {
                session.delete(client);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Select operation
    public Client getClient(int clientId) {
        Session session = sessionFactory.openSession();
        Client client = null;
        try {
            client = session.get(Client.class, clientId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return client;
    }

    // List all clients
    public List<Client> getAllClients() {
        Session session = sessionFactory.openSession();
        List<Client> clients = null;
        try {
            Query<Client> query = session.createQuery("from Client", Client.class);
            clients = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clients;
    }
}
