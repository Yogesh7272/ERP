package org.anudip.service;

import org.anudip.dao.PayrollDao;
import org.anudip.model.Payroll;

import java.util.List;

public class PayrollService {
    private PayrollDao payrollDao;

    public PayrollService() {
        this.payrollDao = new PayrollDao();
    }

    public void addPayroll(Payroll payroll) {
        payrollDao.addPayroll(payroll);
    }

    public void updatePayroll(Payroll payroll) {
        payrollDao.updatePayroll(payroll);
    }

    public void deletePayroll(int payrollId) {
        payrollDao.deletePayroll(payrollId);
    }

    public Payroll getPayroll(int payrollId) {
        return payrollDao.getPayroll(payrollId);
    }

    public List<Payroll> getAllPayrolls() {
        return payrollDao.getAllPayrolls();
    }
}
