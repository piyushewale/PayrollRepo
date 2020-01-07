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

import com.piyush.payroll.entity.SalaryStructure;
import com.piyush.payroll.service.SalaryStructureService;

@RestController
@RequestMapping("/api/salaryStructure")
public class SalaryStructureController {
	
	@Autowired
	private SalaryStructureService salaryStructureService;
	
	@GetMapping("/{roleId}")
	public ResponseEntity getSalaryStructure(@PathVariable Integer roleId) {
		SalaryStructure salaryStructure = salaryStructureService.getSalaryStructure(roleId);
		if(salaryStructure != null)
		 return new ResponseEntity<>(salaryStructure, HttpStatus.OK);
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity createSalaryStructure(@RequestBody SalaryStructure salaryStructure) {
		salaryStructureService.createSalaryStructure(salaryStructure);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PutMapping("/{roleId}")
	public ResponseEntity updateSalaryStructure(@RequestBody SalaryStructure salaryStructure, @PathVariable Integer roleId) {
		salaryStructureService.updateSalaryStructure(roleId, salaryStructure);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@DeleteMapping("/{roleId}")
	public ResponseEntity deleteEmployee(@PathVariable Integer roleId) {
		if(salaryStructureService.deleteSalaryStructure(roleId))
			return new ResponseEntity<>(true, HttpStatus.OK);
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

}
