package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.Entity.DcEducation;


public interface Dc_EducationRepo extends JpaRepository<DcEducation, Integer> {

	
	@Query("SELECT a DcEducation FROM  a WHERE a.caseNum = :caseNum")
	public DcEducation getEdu(Integer caseNum);
}
