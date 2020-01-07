package com.piyush.payroll.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class SalaryPaid {


	@EmbeddedId
	private SalaryPaidIdentity salaryPaidIdentity;
	
	@NotNull
	@Positive
	private Double basic;
	@NotNull
	private Double hra;
	
	@NotNull
	private Double travelAllowance;
	
	@NotNull
	private Double bonus;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basic == null) ? 0 : basic.hashCode());
		result = prime * result + ((bonus == null) ? 0 : bonus.hashCode());
		result = prime * result + ((hra == null) ? 0 : hra.hashCode());
		result = prime * result + ((salaryPaidIdentity == null) ? 0 : salaryPaidIdentity.hashCode());
		result = prime * result + ((travelAllowance == null) ? 0 : travelAllowance.hashCode());
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
		SalaryPaid other = (SalaryPaid) obj;
		if (basic == null) {
			if (other.basic != null)
				return false;
		} else if (!basic.equals(other.basic))
			return false;
		if (bonus == null) {
			if (other.bonus != null)
				return false;
		} else if (!bonus.equals(other.bonus))
			return false;
		if (hra == null) {
			if (other.hra != null)
				return false;
		} else if (!hra.equals(other.hra))
			return false;
		if (salaryPaidIdentity == null) {
			if (other.salaryPaidIdentity != null)
				return false;
		} else if (!salaryPaidIdentity.equals(other.salaryPaidIdentity))
			return false;
		if (travelAllowance == null) {
			if (other.travelAllowance != null)
				return false;
		} else if (!travelAllowance.equals(other.travelAllowance))
			return false;
		return true;
	}

	public SalaryPaid() {
		super();
	}

	public SalaryPaid(SalaryPaidIdentity salaryPaidIdentity, @NotNull @Positive Double basic, @NotNull Double hra,
			@NotNull Double travelAllowance, @NotNull Double bonus) {
		super();
		this.salaryPaidIdentity = salaryPaidIdentity;
		this.basic = basic;
		this.hra = hra;
		this.travelAllowance = travelAllowance;
		this.bonus = bonus;
	}



	public SalaryPaidIdentity getSalaryPaidIdentity() {
		return salaryPaidIdentity;
	}

	public void setSalaryPaidIdentity(SalaryPaidIdentity salaryPaidIdentity) {
		this.salaryPaidIdentity = salaryPaidIdentity;
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

	public Double getTravelAllowance() {
		return travelAllowance;
	}

	public void setTravelAllowance(Double travelAllowance) {
		this.travelAllowance = travelAllowance;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	
}
