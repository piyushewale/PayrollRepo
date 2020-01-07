package com.piyush.payroll.controller;

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

import com.piyush.payroll.entity.SalaryPaid;
import com.piyush.payroll.service.SalaryPaidService;

@RestController
@RequestMapping("/api/salaryPaid")
public class SalaryPaidController {
	
	@Autowired
	private SalaryPaidService salaryPaidService;
	
	@GetMapping("/{employeeId}/{month}/{year}")
	public ResponseEntity getEmployeeSalaryPaid(@PathVariable Integer employeeId, @PathVariable Integer month, @PathVariable Integer year) {
		SalaryPaid salaryPaid = salaryPaidService.getEmployeeSalaryPaid(employeeId, month, year);
		if(salaryPaid != null)
		 return new ResponseEntity<>(salaryPaid, HttpStatus.OK);
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity createSalaryPaid(@RequestBody SalaryPaid salaryPaid) {
		salaryPaidService.createSalaryPaid(salaryPaid);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PutMapping("/{employeeId}/{month}/{year}")
	public ResponseEntity updateSalaryPaid(@RequestBody SalaryPaid salaryPaid, @PathVariable Integer employeeId, @PathVariable Integer month, @PathVariable Integer year) {
		salaryPaidService.updateSalaryPaid(employeeId, month, year, salaryPaid);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@DeleteMapping("/{employeeId}/{month}/{year}")
	public ResponseEntity deleteEmployee(@PathVariable Integer employeeId, @PathVariable Integer month, @PathVariable Integer year) {
		if(salaryPaidService.deleteSalaryPaid(employeeId, month, year))
			return new ResponseEntity<>(true, HttpStatus.OK);
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

}
