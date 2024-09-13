package org.anudip.service;

import org.anudip.dao.PerformanceReviewDao;
import org.anudip.model.PerformanceReview;

import java.util.List;

public class PerformanceReviewService {
    private PerformanceReviewDao performanceReviewDao;

    public PerformanceReviewService() {
        this.performanceReviewDao = new PerformanceReviewDao();
    }

    public void addPerformanceReview(PerformanceReview performanceReview) {
        performanceReviewDao.addPerformanceReview(performanceReview);
    }

    public void updatePerformanceReview(PerformanceReview performanceReview) {
        performanceReviewDao.updatePerformanceReview(performanceReview);
    }

    public void deletePerformanceReview(int reviewId) {
        performanceReviewDao.deletePerformanceReview(reviewId);
    }

    public PerformanceReview getPerformanceReview(int reviewId) {
        return performanceReviewDao.getPerformanceReview(reviewId);
    }

    public List<PerformanceReview> getAllPerformanceReviews() {
        return performanceReviewDao.getAllPerformanceReviews();
    }
}
