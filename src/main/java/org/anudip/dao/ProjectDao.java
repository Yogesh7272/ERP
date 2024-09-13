package org.anudip.dao;

import org.anudip.model.Project;
import org.anudip.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectDao {

    private SessionFactory sessionFactory;

    public ProjectDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    // Insert operation
    public void addProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(project);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update operation
    public void updateProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(project);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete operation
    public void deleteProject(int projectId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Project project = session.get(Project.class, projectId);
            if (project != null) {
                session.delete(project);
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
    public Project getProject(int projectId) {
        Session session = sessionFactory.openSession();
        Project project = null;
        try {
            project = session.get(Project.class, projectId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return project;
    }

    // List all projects
    public List<Project> getAllProjects() {
        Session session = sessionFactory.openSession();
        List<Project> projects = null;
        try {
            Query<Project> query = session.createQuery("from Project", Project.class);
            projects = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return projects;
    }
}
