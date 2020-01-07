package com.piyush.payroll.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyush.payroll.entity.Employee;
import com.piyush.payroll.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Iterable<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> employeeObj = employeeRepository.findById(employeeId);
		if(employeeObj.isPresent())
			return employeeObj.get();
		
		return null;
	}

	@Override
	public Integer createEmployee(Employee employee) {
		Employee persistedEmployee = employeeRepository.save(employee);
		if(persistedEmployee != null)
			return persistedEmployee.getEmployeeId();
		return null;
	}
	
	@Override
	public boolean updateEmployee(int employeeId, Employee employee) {
		Optional<Employee> employeeObj = employeeRepository.findById(employeeId);
		if(employeeObj.isPresent()) {
			Employee existingEmployee = employeeObj.get();
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setDateOfBirth(employee.getDateOfBirth());
			existingEmployee.setCurrentLocation(employee.getCurrentLocation());
			employeeRepository.save(existingEmployee);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Optional<Employee> employeeObj = employeeRepository.findById(employeeId);
		if(employeeObj.isPresent()) {
			employeeRepository.deleteById(employeeId);
			return true;
		}
		return false;
	}

}
