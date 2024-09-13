package org.anudip.dao;

import org.anudip.model.Leave;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.anudip.HibernateUtil;

import java.util.List;

public class LeaveDao {

    private SessionFactory sessionFactory;

    public LeaveDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    // Insert operation
    public void addLeave(Leave leave) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(leave);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update operation
    public void updateLeave(Leave leave) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(leave);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete operation
    public void deleteLeave(int leaveId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Leave leave = session.get(Leave.class, leaveId);
            if (leave != null) {
                session.delete(leave);
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
    public Leave getLeave(int leaveId) {
        Session session = sessionFactory.openSession();
        Leave leave = null;
        try {
            leave = session.get(Leave.class, leaveId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return leave;
    }

    // List all leaves
    public List<Leave> getAllLeaves() {
        Session session = sessionFactory.openSession();
        List<Leave> leaves = null;
        try {
            Query<Leave> query = session.createQuery("from Leave", Leave.class);
            leaves = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return leaves;
    }
}
