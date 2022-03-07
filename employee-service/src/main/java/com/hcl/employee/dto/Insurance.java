package com.hcl.employee.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Insurance {
	
	private Integer employeeId;
	private String healthInsurance;
	private double coverageAmount;
	

}
