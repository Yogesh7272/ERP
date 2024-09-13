package org.anudip.service;

import org.anudip.dao.EmployeeDao;
import org.anudip.model.Employee;
import org.anudip.model.Department;

import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;
    private DepartmentService departmentService;

    public EmployeeService() {
        this.employeeDao = new EmployeeDao();
        this.departmentService = new DepartmentService(); // Initialize DepartmentService
    }

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    public Employee getEmployee(int employeeId) {
        return employeeDao.getEmployee(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    // Fetch a Department by ID
    public Department getDepartment(int departmentId) {
        return departmentService.getDepartment(departmentId);
    }
}
