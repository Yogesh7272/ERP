package org.anudip.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "Payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payroll_id")
    private int payrollId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "base_salary")
    private double baseSalary;

    @Column(name = "deductions")
    private double deductions;

    @Column(name = "net_salary")
    private double netSalary;

    public Payroll() {
    }

    public Payroll(int payrollId, int employeeId, double baseSalary, double deductions, double netSalary) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    public int getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}
