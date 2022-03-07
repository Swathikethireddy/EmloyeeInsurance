package com.hcl.employee.dto;

import lombok.Builder;

@Builder
public class EmployeeInsuranceDto {
	
	private String employeeName;
	private String employeeEmail;
	private String joiningDate;
	private String healthInsurance;
	private double coverageAmount;
	
	public EmployeeInsuranceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeInsuranceDto(String employeeName, String employeeEmail, String joiningDate, String healthInsurance,
			double coverageAmount) {
		super();
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.joiningDate = joiningDate;
		this.healthInsurance = healthInsurance;
		this.coverageAmount = coverageAmount;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
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
	

}


