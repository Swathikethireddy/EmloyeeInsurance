package com.hcl.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.insurance.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer>{

	Insurance findByInsuranceId(Integer insuranceId);

	//List<Insurance> findByInsurancesId(Integer id);

}
