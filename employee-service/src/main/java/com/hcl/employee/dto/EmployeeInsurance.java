
package com.hcl.employee.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeInsurance {
	
	
	private String employeeName;
	private String employeeEmail;
	private String joiningDate;	
	private Insurance insurance;

}
