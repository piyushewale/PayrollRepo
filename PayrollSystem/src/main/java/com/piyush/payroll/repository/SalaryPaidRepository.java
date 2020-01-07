package com.piyush.payroll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.piyush.payroll.entity.SalaryPaid;
import com.piyush.payroll.entity.SalaryPaidIdentity;

@Repository
public interface SalaryPaidRepository extends CrudRepository<SalaryPaid, SalaryPaidIdentity>{

}
