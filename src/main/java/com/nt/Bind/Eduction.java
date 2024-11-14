package com.nt.Bind;

import org.springframework.stereotype.Component;

@Component
public class Eduction {

	public String highestDegree;
	public String graduationYear;
	public String unversity;
	public Integer caseNum;
	public Integer userId;
	
	public String getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public String getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getUnversity() {
		return unversity;
	}
	public void setUnversity(String unversity) {
		this.unversity = unversity;
	}
	public Integer getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	
	
}
