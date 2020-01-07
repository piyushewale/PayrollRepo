package com.piyush.payroll.service;

import org.springframework.stereotype.Service;

import com.piyush.payroll.entity.SalaryPaid;

@Service
public interface SalaryPaidService {
	
	public SalaryPaid getEmployeeSalaryPaid(int employeeId, int month, int year);
	
	public void createSalaryPaid(SalaryPaid salaryPaid);
	
	public boolean deleteSalaryPaid(int employeeId, int month, int year);

	void updateSalaryPaid(int employeeId, int month, int year, SalaryPaid salaryPaid);

}
