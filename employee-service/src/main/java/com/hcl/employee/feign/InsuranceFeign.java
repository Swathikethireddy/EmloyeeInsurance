package com.hcl.employee.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;
import com.hcl.employee.dto.EmployeeInsuranceDto;
import com.hcl.employee.dto.Insurance;

@FeignClient(name = "http://INSURANCE-SERVICE/insurance/")
public interface InsuranceFeign {
	
	 @PostMapping("/{id}")
	 public Insurance saveByInsuranceId(@RequestBody Insurance insurance,@PathVariable("id") Integer insuranceId);

	 @GetMapping("/view/{id}")
	public Insurance findByInsuranceId(@PathVariable("id") Integer insuranceId);
	 
	 @GetMapping("/all/{id}")
		public List<Insurance> findByInsurancesId(@PathVariable("id") Integer id);
	 
	 @PutMapping("/edit/{id}")
     public Insurance editInsurance(@PathVariable("id") Integer employeeId, @RequestBody Insurance insurance );
	 
	 @DeleteMapping("/delete/{id}")
	 public void deleteInsuranceById(@PathVariable("id") Integer id);
	 
	 @PostMapping("/save")
	 public List<Insurance> saveInsuranceList(List<Insurance> insuranceListWithEmpId);
}
