package com.nt.Bind;

import java.util.List;

import org.springframework.stereotype.Component;



@Component
public class DCSummary {

	private Income incomeDetails;
	
	private Eduction educationDetails;
	
	private List<Kids> childernDetails;

	public Income getIncomeDetails() {
		return incomeDetails;
	}

	public void setIncomeDetails(Income incomeDetails) {
		this.incomeDetails = incomeDetails;
	}

	public Eduction getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(Eduction educationDetails) {
		this.educationDetails = educationDetails;
	}

	public List<Kids> getChildernDetails() {
		return childernDetails;
	}

	public void setChildernDetails(List<Kids> childernDetails) {
		this.childernDetails = childernDetails;
	}

	
	
	
}
