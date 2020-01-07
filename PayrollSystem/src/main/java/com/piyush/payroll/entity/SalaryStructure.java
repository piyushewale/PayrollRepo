package com.piyush.payroll.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class SalaryStructure {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;
	@NotNull
	@NotBlank
	@NotEmpty
	private String role;
	@NotNull
	@Positive
	private Double basic;
	@NotNull
	private Double hra;
	@NotNull
	@Positive
	@Min(value = 0, message = "Performance Level should be atleast 0")
    @Max(value = 100, message = "Performance Level should not be greater than 100")
	private int performanceLevel;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basic == null) ? 0 : basic.hashCode());
		result = prime * result + ((hra == null) ? 0 : hra.hashCode());
		result = prime * result + performanceLevel;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		SalaryStructure other = (SalaryStructure) obj;
		if (basic == null) {
			if (other.basic != null)
				return false;
		} else if (!basic.equals(other.basic))
			return false;
		if (hra == null) {
			if (other.hra != null)
				return false;
		} else if (!hra.equals(other.hra))
			return false;
		if (performanceLevel != other.performanceLevel)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (roleId != other.roleId)
			return false;
		return true;
	}

	public SalaryStructure() {
		super();
	}
	
	public SalaryStructure(int roleId, String role, Double basic, Double hra, int performanceLevel) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.basic = basic;
		this.hra = hra;
		this.performanceLevel = performanceLevel;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Double getBasic() {
		return basic;
	}
	public void setBasic(Double basic) {
		this.basic = basic;
	}
	public Double getHra() {
		return hra;
	}
	public void setHra(Double hra) {
		this.hra = hra;
	}
	public int getPerformanceLevel() {
		return performanceLevel;
	}
	public void setPerformanceLevel(int performanceLevel) {
		this.performanceLevel = performanceLevel;
	}
}
