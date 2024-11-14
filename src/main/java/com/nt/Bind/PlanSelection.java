package com.nt.Bind;

import org.springframework.stereotype.Component;

@Component
public class PlanSelection {

	
	private String selPlan;
	
	private Integer caseNum;
	
	private Integer userId;
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSelPlan() {
		return selPlan;
	}

	public void setSelPlan(String selPlan) {
		this.selPlan = selPlan;
	}

	public Integer getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}
	
	
}
