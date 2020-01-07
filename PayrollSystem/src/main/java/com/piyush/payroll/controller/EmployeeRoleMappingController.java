package com.piyush.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.payroll.service.EmployeeRoleMappingService;

@RestController
@RequestMapping("/api/employeeRoleMapping")
public class EmployeeRoleMappingController {
	
	@Autowired
	private EmployeeRoleMappingService employeeRoleMappingService;
	

	@GetMapping("/{employeeId}")
	public ResponseEntity getRoleIdForEmployee(@PathVariable Integer employeeId) {
		int roleId = employeeRoleMappingService.getRoleIdForEmployee(employeeId);
		if(roleId != 0)
		 return new ResponseEntity<>(roleId, HttpStatus.OK);
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/{employeeId}/{roleId}")
	public ResponseEntity createEmployeeRoleMapping(@PathVariable Integer employeeId, @PathVariable Integer roleId) {
		employeeRoleMappingService.createOrUpdateRoleOfEmployee(employeeId, roleId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PutMapping("/{employeeId}/{roleId}")
	public ResponseEntity updateEmployeeRoleMapping(@PathVariable Integer employeeId, @PathVariable Integer roleId) {
		employeeRoleMappingService.createOrUpdateRoleOfEmployee(employeeId, roleId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity deleteEmployeeRole(@PathVariable Integer employeeId) {
		if(employeeRoleMappingService.deleteEmployeeRole(employeeId))
			return new ResponseEntity<>(true, HttpStatus.OK);
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

}
