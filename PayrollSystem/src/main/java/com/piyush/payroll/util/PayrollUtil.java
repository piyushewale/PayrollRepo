package com.piyush.payroll.util;

import java.time.LocalDate;

import com.piyush.payroll.entity.SalaryPaidIdentity;

public class PayrollUtil {
	
	public static SalaryPaidIdentity createSalaryPaidIdentity(int employeeId, int month, int year) {
		LocalDate date = LocalDate.of(year, month, 1);
		return new SalaryPaidIdentity(employeeId, date);
	}

}
