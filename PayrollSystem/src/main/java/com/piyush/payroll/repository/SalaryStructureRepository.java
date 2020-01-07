package com.piyush.payroll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.piyush.payroll.entity.SalaryStructure;

@Repository
public interface SalaryStructureRepository extends CrudRepository<SalaryStructure, Integer>{

}
