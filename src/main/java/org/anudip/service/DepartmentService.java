package org.anudip.service;

import org.anudip.dao.DepartmentDao;
import org.anudip.model.Department;

import java.util.List;

public class DepartmentService {
    private DepartmentDao departmentDao;

    public DepartmentService() {
        this.departmentDao = new DepartmentDao();
    }

    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    public void deleteDepartment(int departmentId) {
        departmentDao.deleteDepartment(departmentId);
    }

    public Department getDepartment(int departmentId) {
        return departmentDao.getDepartment(departmentId);
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
