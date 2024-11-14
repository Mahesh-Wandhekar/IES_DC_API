package com.nt.Service;

import java.util.List;

import com.nt.Bind.DCSummary;
import com.nt.Bind.Eduction;
import com.nt.Bind.Income;
import com.nt.Bind.Kids;
import com.nt.Bind.PlanSelection;

public interface DCService {

	public List<String> getPlans();
	
	public boolean planSelection(PlanSelection selection);
	
	public boolean eduction(Eduction eduction);
	
	public boolean income(Income income);
	
	public boolean kids(Kids kids);
	
	public DCSummary dcSummary(Integer caseNum);
	
}
