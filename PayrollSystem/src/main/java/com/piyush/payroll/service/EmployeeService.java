package com.piyush.payroll.service;

import org.springframework.stereotype.Service;

import com.piyush.payroll.entity.Employee;

@Service
public interface EmployeeService {

	public Iterable<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int employeeId);
	
	public Integer createEmployee(Employee employee);
	
	public boolean deleteEmployee(int employeeId);

	boolean updateEmployee(int employeeId, Employee employee);
}
