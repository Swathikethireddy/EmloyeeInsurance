package com.hcl.employee.service;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.employee.dto.EmployeeInsurance;
import com.hcl.employee.dto.EmployeeInsuranceDto;
import com.hcl.employee.dto.EmployeeInsuranceSet;
import com.hcl.employee.dto.Insurance;
import com.hcl.employee.dto.ResponseDto;
import com.hcl.employee.entity.Employee;
import com.hcl.employee.entity.Employee.EmployeeBuilder;
import com.hcl.employee.feign.InsuranceFeign;
import com.hcl.employee.repository.EmployeeRepository;
import com.hcl.insurance.repository.InsuranceRepository;

@Service
public class EmployeeService {

	
	@Autowired
	private InsuranceFeign insuranceFeign;
	
	@Autowired
	EmployeeRepository employeeRepository;

	//save employee
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}	
	

	//findall
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	//find by id
	public Employee getEmployeeById(Integer employeeId) {

		return employeeRepository.findByEmployeeId(employeeId);
	}

	//save employee with feign
	public String saveEmployeeWithInsurance(EmployeeInsuranceDto employeeInsuranceDto) {
		Employee employee = Employee.builder()
				.employeeName(employeeInsuranceDto.getEmployeeName())
				.employeeEmail(employeeInsuranceDto.getEmployeeEmail())
				.joiningDate(employeeInsuranceDto.getJoiningDate())
				.build();
		Employee emp = employeeRepository.save(employee);
		Insurance insurance = Insurance.builder()
				.employeeId(emp.getEmployeeId())
				.healthInsurance(employeeInsuranceDto.getHealthInsurance())
				.coverageAmount(employeeInsuranceDto.getCoverageAmount())
				.build(); 
		insuranceFeign.saveByInsuranceId(insurance, emp.getEmployeeId());
		
		return "Employee Details saved successfully";			
	}
	
/*
	// get all by employee id
	public ResponseDto getEmployeeWithInsurance(Integer employeeId) {
		ResponseDto responseDto = new ResponseDto();
		Employee employee = employeeRepository.findByEmployeeId(employeeId);
		Insurance insurance =insuranceFeign.findByInsuranceId(employee.getEmployeeId());
		responseDto.setEmployee(employee);
		responseDto.setInsurance(insurance);
		return responseDto;
			}
	*/
	
	//get employee with insurance
	  public ResponseDto getEmployeeWithInsurance(Integer employeeId) {
		  ResponseDto responseDto= new ResponseDto();
	    	Employee employee=employeeRepository.findByEmployeeId(employeeId);
	    	Insurance insurance=insuranceFeign.findByInsuranceId(employee.getEmployeeId());
	    	responseDto.setEmployee(employee);
	    	responseDto.setInsurance(insurance);
			return responseDto;
	    	
	    }

	  public EmployeeInsuranceSet getEmployeeWithInsurances(Integer employeeId) {
		 // ResponseDto responseDto= new ResponseDto();
		  EmployeeInsuranceSet empInsSet= new EmployeeInsuranceSet();
	    	Employee employee=employeeRepository.findByEmployeeId(employeeId);
	    	List<Insurance> insurance=insuranceFeign.findByInsurancesId(employee.getEmployeeId());
	    	empInsSet.setEmployee(employee);
	    	empInsSet.setInsurance(insurance);
			return empInsSet;
	    	
	    }
	  
	  //get all insurance and employee 
	public List<EmployeeInsurance> getAllinsurancesWithEmployeeInsurance(Integer employeeId) {
	
			List<EmployeeInsurance> employeeList = new ArrayList<>();
			List<Employee> employee = employeeRepository.findAll();
			employee.forEach(e -> 	{
				Insurance insurance = insuranceFeign.findByInsuranceId(e.getEmployeeId());
				EmployeeInsurance employeeInsurance = EmployeeInsurance.builder()
						.employeeEmail(e.getEmployeeEmail())
						.employeeName(e.getEmployeeName())
						.joiningDate(e.getJoiningDate())
						.insurance(insurance)
						.build();
				employeeList.add(employeeInsurance);
						
			});
			return employeeList;
	}
	

	public String updateEmployeeWithInsurance(Integer employeeId, EmployeeInsuranceDto employeeInsuranceDto) {
        Employee employee = employeeRepository.findById(employeeId).get().builder()
                .employeeId(employeeId)
                .employeeName(employeeInsuranceDto.getEmployeeName())
                .employeeEmail(employeeInsuranceDto.getEmployeeEmail())
                .joiningDate(employeeInsuranceDto.getJoiningDate())
                .build();
        Insurance insurance =insuranceFeign.findByInsuranceId(employeeId).builder()
                .employeeId(employee.getEmployeeId())
                .healthInsurance(employeeInsuranceDto.getHealthInsurance())
                .coverageAmount( employeeInsuranceDto.getCoverageAmount())
                .build();
        employeeRepository.save(employee);
        insuranceFeign.editInsurance(employeeId, insurance);
        return "Updated successfully";
    }
	//delete
	public String deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
		insuranceFeign.deleteInsuranceById(id);
		return "employeee deleted succefully";
		}

	
	public ResponseDto addEmployeeWithInsurance(ResponseDto responseDto) {
		Employee employee = Employee.builder()
				.employeeName(responseDto.getEmployee().getEmployeeName())
				.employeeEmail(responseDto.getEmployee().getEmployeeEmail())
				.joiningDate(responseDto.getEmployee().getJoiningDate())
				.build();
		Employee emp = employeeRepository.save(employee);
		Insurance insurance = Insurance.builder()
				.employeeId(emp.getEmployeeId())
				.healthInsurance(responseDto.getInsurance().getHealthInsurance())
				.coverageAmount(responseDto.getInsurance().getCoverageAmount())
				.build(); 
		insuranceFeign.saveByInsuranceId(insurance, emp.getEmployeeId());
		ResponseDto response=new ResponseDto();
		response.setEmployee(employee);
		response.setInsurance(insurance);
			

		return response;			
	}
	
	public ResponseDto updateEmployeeAndInsurance(Integer employeeId, ResponseDto responseDto) {
	       
        ResponseDto response=new ResponseDto();
        Employee empObj = employeeRepository.findByEmployeeId(employeeId);
        empObj.setEmployeeId(employeeId);
        empObj.setEmployeeName(responseDto.getEmployee().getEmployeeName());
        empObj.setEmployeeEmail(responseDto.getEmployee().getEmployeeEmail());
        empObj.setJoiningDate(responseDto.getEmployee().getJoiningDate());
       // Employee emp = employeeInsuranceRepository.save(empObj);
        Employee emp = employeeRepository.save(empObj);
        Insurance insurance=insuranceFeign.findByInsuranceId(employeeId);
        insurance.setEmployeeId(employeeId);
        insurance.setHealthInsurance(responseDto.getInsurance().getHealthInsurance());
        insurance.setCoverageAmount(responseDto.getInsurance().getCoverageAmount());
        insuranceFeign.editInsurance(emp.getEmployeeId(), insurance);
        response.setEmployee(emp);
        response.setInsurance(insurance);
       
        return response;
    }
	
	public EmployeeInsuranceSet employeeAndInsurances(EmployeeInsuranceSet empins) {
		Employee employee = Employee.builder()
				.employeeName(empins.getEmployee().getEmployeeName())
				.employeeEmail(empins.getEmployee().getEmployeeEmail())
				.joiningDate(empins.getEmployee().getJoiningDate())
				.build();
		employeeRepository.save(employee);
		List<Insurance> insuranceListWOEmpId = empins.getInsurance();
		List<Insurance> insuranceListWithEmpId = new ArrayList<>();
		for(Insurance ins:insuranceListWOEmpId) {
			ins.setEmployeeId(employee.getEmployeeId());
			insuranceListWithEmpId.add(ins);
		}
		List<Insurance> insuranceList=insuranceFeign.saveInsuranceList(insuranceListWithEmpId);
		EmployeeInsuranceSet set= EmployeeInsuranceSet.builder()
				.employee(employee)
				.insurance(insuranceList)
				.build(); 
		
		return set;			
    }
}
