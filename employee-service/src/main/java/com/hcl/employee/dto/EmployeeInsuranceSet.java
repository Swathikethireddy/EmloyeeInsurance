package com.hcl.employee.dto;

import java.util.List;

import com.hcl.employee.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInsuranceSet {
	private Employee employee;
	private List<Insurance> insurance;
}
