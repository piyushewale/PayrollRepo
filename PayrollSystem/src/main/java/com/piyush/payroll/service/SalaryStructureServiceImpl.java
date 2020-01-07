package com.piyush.payroll.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyush.payroll.entity.SalaryStructure;
import com.piyush.payroll.repository.SalaryStructureRepository;

@Service
public class SalaryStructureServiceImpl implements SalaryStructureService{
	
	@Autowired
	private SalaryStructureRepository salaryStructureRepository;

	@Override
	public SalaryStructure getSalaryStructure(int roleId) {
		Optional<SalaryStructure> salaryStructureObj = salaryStructureRepository.findById(roleId);
		if(salaryStructureObj.isPresent())
			return salaryStructureObj.get();
		return null;
	}

	@Override
	public void createSalaryStructure(SalaryStructure salaryStructure) {
		salaryStructureRepository.save(salaryStructure);
		
	}
	
	@Override
	public void updateSalaryStructure(int roleId, SalaryStructure salaryStructure) {
		Optional<SalaryStructure> salaryStructureObj = salaryStructureRepository.findById(roleId);
		if(salaryStructureObj.isPresent()) {
			SalaryStructure existingSalaryStructure = salaryStructureObj.get();
			existingSalaryStructure.setBasic(salaryStructure.getBasic());
			existingSalaryStructure.setHra(salaryStructure.getHra());
			existingSalaryStructure.setPerformanceLevel(salaryStructure.getPerformanceLevel());
			salaryStructureRepository.save(existingSalaryStructure);
		}
	}

	@Override
	public boolean deleteSalaryStructure(int roleId) {
		Optional<SalaryStructure> salaryStructureObj = salaryStructureRepository.findById(roleId);
		if(salaryStructureObj.isPresent()) {
			salaryStructureRepository.deleteById(roleId);
			return true;
		}
		return false;
	}

}
