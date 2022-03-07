package com.hcl.employee.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.dto.EmployeeInsurance;
import com.hcl.employee.dto.EmployeeInsuranceDto;
import com.hcl.employee.dto.EmployeeInsuranceSet;
import com.hcl.employee.dto.ResponseDto;
import com.hcl.employee.entity.Employee;
import com.hcl.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
	
	@Autowired 
	private EmployeeService employeeService;
	
	@PostMapping("/")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/view")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/view/{id}")
	public Employee findByEmployeeId(@PathVariable("id") Integer employeeId){
		return employeeService.getEmployeeById(employeeId);
	}

	/*@PostMapping("/join")
	public String saveEmployeeAndInsurance(@RequestBody EmployeeInsuranceDto employeeInsuranceDto) {
		return employeeService.saveEmployeeWithInsurance(employeeInsuranceDto);
	}*/
	
	//localhost:8080/employee/id
/*	@GetMapping("/{id}")
	public ResponseDto getEmployeeWithInsurance(@PathVariable("id") Integer employeeId) {
	   return employeeService.getEmployeeWithInsurance(employeeId);
		
	}
	*/
	@GetMapping("/{id}")
	public ResponseDto getEmployeeWithInsurance(@PathVariable("id") Integer employeeId) {
		return employeeService.getEmployeeWithInsurance(employeeId);
	}
	
	@GetMapping("all/{id}")
	public EmployeeInsuranceSet getEmployeeWithInsurances(@PathVariable("id") Integer employeeId) {
		return employeeService.getEmployeeWithInsurances(employeeId);
	}
	
	//localhost:8080/employee/id
	@GetMapping("find/{id}")
	public List<EmployeeInsurance> getAllinsurancesWithEmployeeInsurance(@PathVariable("id") Integer employeeId){
		return employeeService.getAllinsurancesWithEmployeeInsurance(employeeId);
	}
	
	@PutMapping("/update/{id}")
    public String updateEmployeeWithInsurance(@PathVariable("id") Integer employeeId, @RequestBody EmployeeInsuranceDto employeeInsuranceDto) {
        return employeeService.updateEmployeeWithInsurance(employeeId, employeeInsuranceDto);
    }
	

	//localhost:8080/employee/put/id
/*	@PutMapping("/put/{id}")
	public String editEmployeeWithInsurance( @PathVariable("id") Integer employeeId,@RequestBody EmployeeInsuranceDto employeeInsuranceDto) {
		return employeeService.editEmployeeWithInsurance(employeeId,employeeInsuranceDto);
	}
	*/
	
	//localhost:8080/employee/delete/id
	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable Integer id) {
	return employeeService.deleteEmployeeById(id);
	}
	
	@PostMapping("/join")
	public ResponseDto addEmployeeAndInsurance(@RequestBody ResponseDto responseDto) {
		return employeeService.addEmployeeWithInsurance(responseDto);
	}

	@PutMapping("/edit/{id}")
    public ResponseDto updateEmployeeAndInsurance(@PathVariable("id") Integer employeeId,@RequestBody ResponseDto responseDto) 
	{
        return employeeService.updateEmployeeAndInsurance(employeeId,responseDto);
    }
	
	@PostMapping("/insert")
    public EmployeeInsuranceSet employeeAndInsurances(@RequestBody EmployeeInsuranceSet empins) 
	{
        return employeeService.employeeAndInsurances(empins);
    }
}
