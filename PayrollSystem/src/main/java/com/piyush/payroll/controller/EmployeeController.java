package com.piyush.payroll.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.payroll.entity.Employee;
import com.piyush.payroll.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public Iterable<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/piyush")
	public Employee testEmployee() {
		Employee emp = new Employee(0, "ABC", "XYZ", LocalDate.of(2020, 1, 31), "Pune");
		employeeService.createEmployee(emp);
		return emp;
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity getEmployee(@PathVariable Integer employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		if(employee != null)
		 return new ResponseEntity<>(employee, HttpStatus.OK);
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity createEmployee(@RequestBody Employee employee) {
		Integer employeeId = employeeService.createEmployee(employee); 
		if(employeeId != null)
			return new ResponseEntity<>(employeeId, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.METHOD_FAILURE);
	}

	@PutMapping("/{employeeId}")
	public ResponseEntity updateEmployee(@RequestBody Employee employee, @PathVariable Integer employeeId) {
		if(employeeService.updateEmployee(employeeId, employee))
			return new ResponseEntity<>(null, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.METHOD_FAILURE);
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity deleteEmployee(@PathVariable Integer employeeId) {
		if(employeeService.deleteEmployee(employeeId))
			return new ResponseEntity<>(null, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
