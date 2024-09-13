package org.anudip.service;

import org.anudip.dao.LeaveDao;
import org.anudip.model.Leave;

import java.util.List;

public class LeaveService {
    private LeaveDao leaveDao;

    public LeaveService() {
        this.leaveDao = new LeaveDao();
    }

    public void addLeave(Leave leave) {
        leaveDao.addLeave(leave);
    }

    public void updateLeave(Leave leave) {
        leaveDao.updateLeave(leave);
    }

    public void deleteLeave(int leaveId) {
        leaveDao.deleteLeave(leaveId);
    }

    public Leave getLeave(int leaveId) {
        return leaveDao.getLeave(leaveId);
    }

    public List<Leave> getAllLeaves() {
        return leaveDao.getAllLeaves();
    }
}
