package com.piyush.payroll.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class SalaryPaidIdentity implements Serializable{
	
	@Positive
	private int employeeId;
	
	@NotNull
	private LocalDate date;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + employeeId;
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
		SalaryPaidIdentity other = (SalaryPaidIdentity) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}

	public SalaryPaidIdentity() {
		super();
	}

	public SalaryPaidIdentity(int employeeId, LocalDate date) {
		super();
		this.employeeId = employeeId;
		this.date = date;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
