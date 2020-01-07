package com.piyush.payroll.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyush.payroll.entity.SalaryPaid;
import com.piyush.payroll.entity.SalaryPaidIdentity;
import com.piyush.payroll.repository.SalaryPaidRepository;
import com.piyush.payroll.util.PayrollUtil;

@Service
public class SalaryPaidServiceImpl implements SalaryPaidService {
	
	@Autowired
	private SalaryPaidRepository salaryPaidRepository;

	@Override
	public SalaryPaid getEmployeeSalaryPaid(int employeeId, int month, int year) {
		Optional<SalaryPaid> salaryPaidObj = salaryPaidRepository.findById(PayrollUtil.createSalaryPaidIdentity(employeeId, month, year));
		if(salaryPaidObj.isPresent())
			return salaryPaidObj.get();
		return null;
	}

	@Override
	public void createSalaryPaid(SalaryPaid salaryPaid) {
		salaryPaidRepository.save(salaryPaid);
	}
	
	@Override
	public void updateSalaryPaid(int employeeId, int month, int year, SalaryPaid salaryPaid) {
		Optional<SalaryPaid> existingSalaryPaidObj = salaryPaidRepository.findById(PayrollUtil.createSalaryPaidIdentity(employeeId, month, year));
		if(existingSalaryPaidObj.isPresent()) {
			SalaryPaid existingSalaryPaid = existingSalaryPaidObj.get();
			existingSalaryPaid.setBasic(salaryPaid.getBasic());
			existingSalaryPaid.setBonus(salaryPaid.getBonus());
			existingSalaryPaid.setHra(salaryPaid.getHra());
			existingSalaryPaid.setTravelAllowance(salaryPaid.getTravelAllowance());
			salaryPaidRepository.save(existingSalaryPaid);
		}
	}

	@Override
	public boolean deleteSalaryPaid(int employeeId, int month, int year) {
		SalaryPaidIdentity salaryPaidIdentity = PayrollUtil.createSalaryPaidIdentity(employeeId, month, year);
		Optional<SalaryPaid> salaryPaidObj = salaryPaidRepository.findById(salaryPaidIdentity);
		if(salaryPaidObj.isPresent()) {
			salaryPaidRepository.deleteById(salaryPaidIdentity);
			return true;
		}
		return false;
	}

}
