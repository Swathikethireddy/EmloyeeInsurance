package com.hcl.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hcl.insurance.dto.InsuranceDto;
import com.hcl.insurance.entity.Insurance;
import com.hcl.insurance.repository.InsuranceRepository;

@Service
public class InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;

	public Insurance saveInsurance(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}

	// findall
	public List<Insurance> getAllInsurances() {
		// TODO Auto-generated method stub
		return insuranceRepository.findAll();
	}

	// find by insurance id
	public Insurance getInsuranceById(Integer insuranceId) {

		return insuranceRepository.findByInsuranceId(insuranceId);
	}
	
	public List<Insurance> getInsurancesById(Integer id) {
		List<Insurance> i=new ArrayList<Insurance>();
		for(Insurance ins:insuranceRepository.findAll()) {
			if((ins.getEmployeeId()).equals(id)) {
				i.add(ins);
			}
		}
		
		return i;
	}

	public Insurance saveEmployeeById(InsuranceDto insuranceDto, Integer employeeId) {
		Insurance insurance = Insurance.builder()
				.employeeId(employeeId)
				.healthInsurance(insuranceDto.getHealthInsurance())
				.coverageAmount(insuranceDto.getCoverageAmount())
				.build();
		return insuranceRepository.save(insurance);
	}

	 public Insurance editInsurance(Integer employeeId, InsuranceDto insuranceDto) {
         Insurance insurance=insuranceRepository.findByInsuranceId(employeeId);
         insurance.setHealthInsurance(insuranceDto.getHealthInsurance());
         insurance.setCoverageAmount(insuranceDto.getCoverageAmount());
         insurance.setEmployeeId(employeeId);
         return insuranceRepository.save(insurance)  ;
     }
	 
	 public String deleteInsuranceById(Integer id) {
		 insuranceRepository.deleteById(id);
		 return "insurance deleted succefully";
		 }
	 
	 public List<Insurance> saveInsuranceList(List<Insurance> insurance){
		 return insuranceRepository.saveAll(insurance);
	 }
}
