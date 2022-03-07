package com.hcl.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
public class Insurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer insuranceId;
	private String healthInsurance;
	private double coverageAmount;
	private Integer employeeId;
	
	public Insurance() {
		
	}
	public Insurance(Integer insuranceId, String healthInsurance, double coverageAmount, Integer employeeId) {
		super();
		this.insuranceId = insuranceId;
		this.healthInsurance = healthInsurance;
		this.coverageAmount = coverageAmount;
		this.employeeId = employeeId;
	}
	public Integer getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getHealthInsurance() {
		return healthInsurance;
	}
	public void setHealthInsurance(String healthInsurance) {
		this.healthInsurance = healthInsurance;
	}
	public double getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	
	

}
