package org.anudip.service;

import org.anudip.dao.AttendanceDao;
import org.anudip.model.Attendance;

import java.util.List;

public class AttendanceService {

    private AttendanceDao attendanceDao;

    public AttendanceService() {
        this.attendanceDao = new AttendanceDao();
    }

    public void addAttendance(Attendance attendance) {
        attendanceDao.addAttendance(attendance);
    }

    public void updateAttendance(Attendance attendance) {
        attendanceDao.updateAttendance(attendance);
    }

    public void deleteAttendance(int attendanceId) {
        attendanceDao.deleteAttendance(attendanceId);
    }

    public Attendance getAttendance(int attendanceId) {
        return attendanceDao.getAttendance(attendanceId);
    }

    public List<Attendance> getAllAttendances() {
        return attendanceDao.getAllAttendances();
    }
}
