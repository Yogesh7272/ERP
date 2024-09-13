package org.anudip.dao;

import org.anudip.model.Payroll;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.anudip.HibernateUtil;

import java.util.List;

public class PayrollDao {

    private SessionFactory sessionFactory;

    public PayrollDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    // Insert operation
    public void addPayroll(Payroll payroll) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(payroll);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update operation
    public void updatePayroll(Payroll payroll) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(payroll);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete operation
    public void deletePayroll(int payrollId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Payroll payroll = session.get(Payroll.class, payrollId);
            if (payroll != null) {
                session.delete(payroll);
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
    public Payroll getPayroll(int payrollId) {
        Session session = sessionFactory.openSession();
        Payroll payroll = null;
        try {
            payroll = session.get(Payroll.class, payrollId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return payroll;
    }

    // List all payroll records
    public List<Payroll> getAllPayrolls() {
        Session session = sessionFactory.openSession();
        List<Payroll> payrolls = null;
        try {
            Query<Payroll> query = session.createQuery("from Payroll", Payroll.class);
            payrolls = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return payrolls;
    }
}
