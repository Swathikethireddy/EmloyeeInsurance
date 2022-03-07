package com.hcl.insurance.dto;

public class InsuranceDto {
	
	private String healthInsurance;
	private double coverageAmount;
	
	public InsuranceDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public InsuranceDto(String healthInsurance, double coverageAmount) {
		super();
		this.healthInsurance = healthInsurance;
		this.coverageAmount = coverageAmount;
	}
	

}
