package org.anudip.dao;

import org.anudip.model.Attendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.anudip.HibernateUtil;

import java.util.List;

public class AttendanceDao {

    private SessionFactory sessionFactory;

    public AttendanceDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    // Insert operation
    public void addAttendance(Attendance attendance) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(attendance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update operation
    public void updateAttendance(Attendance attendance) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(attendance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete operation
    public void deleteAttendance(int attendanceId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Attendance attendance = session.get(Attendance.class, attendanceId);
            if (attendance != null) {
                session.delete(attendance);
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
    public Attendance getAttendance(int attendanceId) {
        Session session = sessionFactory.openSession();
        Attendance attendance = null;
        try {
            attendance = session.get(Attendance.class, attendanceId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return attendance;
    }

    // List all attendances
    public List<Attendance> getAllAttendances() {
        Session session = sessionFactory.openSession();
        List<Attendance> attendances = null;
        try {
            Query<Attendance> query = session.createQuery("from Attendance", Attendance.class);
            attendances = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return attendances;
    }
}
