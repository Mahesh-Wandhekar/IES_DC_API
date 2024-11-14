package com.nt.Bind;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Kids {

	
	private Integer caseNum;
	private Integer userId;
	private List<Kid> kidList;
	
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
	public List<Kid> getKidList() {
		return kidList;
	}
	public void setKidList(List<Kid> kidList) {
		this.kidList = kidList;
	}
	
	
	
	
}
