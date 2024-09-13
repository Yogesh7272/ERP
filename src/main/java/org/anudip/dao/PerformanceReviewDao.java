package org.anudip.dao;

import org.anudip.model.PerformanceReview;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.anudip.HibernateUtil;

import java.util.List;

public class PerformanceReviewDao {

    private SessionFactory sessionFactory;

    public PerformanceReviewDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    // Insert operation
    public void addPerformanceReview(PerformanceReview performanceReview) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(performanceReview);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update operation
    public void updatePerformanceReview(PerformanceReview performanceReview) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(performanceReview);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete operation
    public void deletePerformanceReview(int reviewId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PerformanceReview performanceReview = session.get(PerformanceReview.class, reviewId);
            if (performanceReview != null) {
                session.delete(performanceReview);
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
    public PerformanceReview getPerformanceReview(int reviewId) {
        Session session = sessionFactory.openSession();
        PerformanceReview performanceReview = null;
        try {
            performanceReview = session.get(PerformanceReview.class, reviewId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return performanceReview;
    }

    // List all performance reviews
    public List<PerformanceReview> getAllPerformanceReviews() {
        Session session = sessionFactory.openSession();
        List<PerformanceReview> performanceReviews = null;
        try {
            Query<PerformanceReview> query = session.createQuery("from PerformanceReview", PerformanceReview.class);
            performanceReviews = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return performanceReviews;
    }
}
