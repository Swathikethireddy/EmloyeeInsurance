package com.hcl.insurance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.InsuranceDto;
import com.hcl.insurance.entity.Insurance;
import com.hcl.insurance.service.InsuranceService;


@RestController
@RequestMapping("/insurance")
public class InsuranceController {
	

	@Autowired 
	private InsuranceService insuranceService;
	
	@PostMapping("/")
	public Insurance saveInsurance(@RequestBody Insurance insurance) {
		return insuranceService.saveInsurance(insurance);
	}
	
	//localhost:8080/insurance/view
	@GetMapping("/view")
	public List<Insurance> getAllInsurances() {
	//	logger.info("Entering employee controller get all employees method");
		return insuranceService.getAllInsurances();
	}

	//localhost:8080/insurance/view/id
	@GetMapping("/view/{id}")
	public Insurance findByInsuranceId(@PathVariable("id") Integer insuranceId){
		return insuranceService.getInsuranceById(insuranceId);
	}
	
	@GetMapping("/all/{id}")
	public List<Insurance> findByInsurancesId(@PathVariable("id") Integer id){
		return insuranceService.getInsurancesById(id);
	}
	
	@PostMapping(value = "/{id}")
	public Insurance saveByEmployeeId(@RequestBody InsuranceDto insuranceDto,@PathVariable("id") Integer  employeeId){
	return insuranceService.saveEmployeeById(insuranceDto,employeeId);
	}
	
	@PutMapping("/edit/{id}")
    public Insurance editInsurance(@PathVariable("id") Integer employeeId, @RequestBody InsuranceDto insuranceDto ) {
        return insuranceService.editInsurance(employeeId,insuranceDto);
    }
	
	@DeleteMapping("/delete/{id}")
	public String deleteInsuranceById(@PathVariable Integer id) {
	return insuranceService.deleteInsuranceById(id);
	}
	
	@PostMapping("/save")
	public List<Insurance> saveInurance(@RequestBody List<Insurance> insurance){
	return insuranceService.saveInsuranceList(insurance);
	}
}
