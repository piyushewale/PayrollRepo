package com.piyush.payroll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.piyush.payroll.entity.EmployeeRoleMapping;

@Repository
public interface EmployeeRoleMappingRepository extends CrudRepository<EmployeeRoleMapping, Integer>{

}
