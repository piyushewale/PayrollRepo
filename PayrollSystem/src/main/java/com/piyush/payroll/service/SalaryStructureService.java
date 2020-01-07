package com.piyush.payroll.service;

import org.springframework.stereotype.Service;

import com.piyush.payroll.entity.SalaryStructure;

@Service
public interface SalaryStructureService {
	
	public SalaryStructure getSalaryStructure(int roleId);
	
	public void createSalaryStructure(SalaryStructure salaryStructure);
	
	public boolean deleteSalaryStructure(int roleId);

	void updateSalaryStructure(int roleId, SalaryStructure salaryStructure);

}
