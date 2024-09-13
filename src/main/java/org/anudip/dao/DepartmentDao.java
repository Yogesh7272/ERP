package org.anudip.dao;

import org.anudip.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.anudip.HibernateUtil;

import java.util.List;

public class DepartmentDao {

    private SessionFactory sessionFactory;

    public DepartmentDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    // Insert operation
    public void addDepartment(Department department) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update operation
    public void updateDepartment(Department department) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete operation
    public void deleteDepartment(int departmentId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Department department = session.get(Department.class, departmentId);
            if (department != null) {
                session.delete(department);
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
    public Department getDepartment(int departmentId) {
        Session session = sessionFactory.openSession();
        Department department = null;
        try {
            department = session.get(Department.class, departmentId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return department;
    }

    // List all departments
    public List<Department> getAllDepartments() {
        Session session = sessionFactory.openSession();
        List<Department> departments = null;
        try {
            Query<Department> query = session.createQuery("from Department", Department.class);
            departments = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return departments;
    }
}
