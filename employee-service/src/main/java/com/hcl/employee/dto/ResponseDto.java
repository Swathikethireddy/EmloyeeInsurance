package com.hcl.employee.dto;
import java.util.*;
import com.hcl.employee.entity.Employee;

public class ResponseDto {
	
	private Employee employee;
	private Insurance insurance;
	//private Set<Insurance> insuranceList;
	
	public ResponseDto(Employee employee, Insurance insurance) {
	super();
	this.employee = employee;
	this.insurance = insurance;
}

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/*public Set<Insurance> getInsuranceList() {
		return insuranceList;
	}

	public void setInsuranceList(Set<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}

	public ResponseDto(Employee employee, Set<Insurance> insuranceList) {
		super();
		this.employee = employee;
		this.insuranceList = insuranceList;
	}*/

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}


	

}
