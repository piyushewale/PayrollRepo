package com.piyush.payroll.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyush.payroll.entity.EmployeeRoleMapping;
import com.piyush.payroll.repository.EmployeeRoleMappingRepository;

@Service
public class EmployeeRoleMappingServiceImpl implements EmployeeRoleMappingService {
	
	@Autowired
	private EmployeeRoleMappingRepository employeeRoleMappingRepository;

	@Override
	public int getRoleIdForEmployee(int employeeId) {
		Optional<EmployeeRoleMapping> employeeRoleMapping = employeeRoleMappingRepository.findById(employeeId);
		if(employeeRoleMapping.isPresent())
			return employeeRoleMapping.get().getRoleId();
		return 0;
	}

	@Override
	public void createOrUpdateRoleOfEmployee(int employeeId, int roleId) {
		Optional<EmployeeRoleMapping> employeeRoleMapping = employeeRoleMappingRepository.findById(employeeId);
		if(employeeRoleMapping.isPresent()) {
			EmployeeRoleMapping existingEmployeeRoleMapping = employeeRoleMapping.get();
			existingEmployeeRoleMapping.setRoleId(roleId);
			employeeRoleMappingRepository.save(existingEmployeeRoleMapping);
		}else {
			EmployeeRoleMapping newEmployeeRoleMapping = new EmployeeRoleMapping(employeeId, roleId);
			employeeRoleMappingRepository.save(newEmployeeRoleMapping);
		}
	}

	@Override
	public boolean deleteEmployeeRole(int employeeId) {
		Optional<EmployeeRoleMapping> employeeRoleMapping = employeeRoleMappingRepository.findById(employeeId);
		if(employeeRoleMapping.isPresent()) {
			employeeRoleMappingRepository.deleteById(employeeId);
			return true;
		}
		return false;
	}
}
