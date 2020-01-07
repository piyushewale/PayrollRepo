package com.piyush.payroll.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Entity
public class EmployeeRoleMapping {

	@Id
	@Positive
	private int employeeId;
	@Positive
	private int roleId;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + roleId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRoleMapping other = (EmployeeRoleMapping) obj;
		if (employeeId != other.employeeId)
			return false;
		if (roleId != other.roleId)
			return false;
		return true;
	}

	public EmployeeRoleMapping() {
		super();
	}

	public EmployeeRoleMapping(int employeeId, int roleId) {
		super();
		this.employeeId = employeeId;
		this.roleId = roleId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	
}
