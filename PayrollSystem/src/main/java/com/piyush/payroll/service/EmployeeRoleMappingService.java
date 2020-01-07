package com.piyush.payroll.service;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeRoleMappingService {
	
	public int getRoleIdForEmployee(int employeeId);
	
	public void createOrUpdateRoleOfEmployee(int employeeId, int roleId);
	
	public boolean deleteEmployeeRole(int employeeId);

}
