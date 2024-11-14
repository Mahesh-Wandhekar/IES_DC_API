package com.nt.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Bind.DCSummary;
import com.nt.Bind.Eduction;
import com.nt.Bind.Income;
import com.nt.Bind.Kid;
import com.nt.Bind.Kids;
import com.nt.Bind.PlanSelection;
import com.nt.Entity.ApplicationEntity;
import com.nt.Entity.DcChildren;
import com.nt.Entity.DcEducation;
import com.nt.Entity.DcIncome;
import com.nt.Entity.DcPlanSelectionEntity;
import com.nt.Entity.PlansEntity;
import com.nt.Repository.DcChildrenRepo;
import com.nt.Repository.DcIncomeRepo;
import com.nt.Repository.DcPlanSelectionRepo;
import com.nt.Repository.Dc_EducationRepo;
import com.nt.Repository.IESApplicationRepo;
import com.nt.Repository.IESPlansRepo;

@Service
public class DCServiceImp implements DCService {

	@Autowired
	private DcPlanSelectionRepo planSelectionRepo;

	@Autowired
	private IESPlansRepo iesPlansRepo;

	@Autowired
	private IESApplicationRepo applicationRepo;

	@Autowired
	private Dc_EducationRepo educationRepo;

	@Autowired
	private DcIncomeRepo incomeRepo;

	@Autowired
	private DcChildrenRepo childrenRepo;

	@Override
	public List<String> getPlans() {
		List<PlansEntity> entities = iesPlansRepo.findAll();
		List<String> list = new ArrayList<String>();
		for (PlansEntity entity : entities) {
			list.add(entity.getPlanName());
		}
		return list;
	}

	@Override
	public boolean planSelection(PlanSelection selection) {
		ApplicationEntity applicationEntity = applicationRepo.findById(selection.getCaseNum()).get();
		if (null == applicationEntity) {
			return false;
		}
		DcPlanSelectionEntity entity = new DcPlanSelectionEntity();
		BeanUtils.copyProperties(selection, entity);
		entity.setCaseNum(applicationEntity);
		planSelectionRepo.save(entity);
		return true;
	}

	@Override
	public boolean eduction(Eduction eduction) {
		ApplicationEntity applicationEntity = applicationRepo.findById(eduction.getCaseNum()).get();
		if (null == applicationEntity) {
			return false;
		}
		DcEducation dcEducation = new DcEducation();
		BeanUtils.copyProperties(eduction, dcEducation);
		dcEducation.setCaseNum(applicationEntity);
		educationRepo.save(dcEducation);
		return true;
	}

	@Override
	public boolean income(Income income) {
		ApplicationEntity applicationEntity = applicationRepo.findById(income.getCaseNum()).get();
		if (null == applicationEntity) {
			return false;
		}
		DcIncome dcIncome = new DcIncome();
		BeanUtils.copyProperties(income, dcIncome);
		dcIncome.setCaseNum(applicationEntity);
		incomeRepo.save(dcIncome);
		return true;
	}

	@Override
	public boolean kids(Kids kids) {
		
		ApplicationEntity applicationEntity = applicationRepo.findById(kids.getCaseNum()).get();
		if(null==applicationEntity) {
			return false;
		}
		
		
		List<Kid> kidlist=kids.getKidList();
		Integer caseNum=kids.getCaseNum();
		
		for(Kid kid:kidlist) {
			DcChildren children=new DcChildren();
			BeanUtils.copyProperties(kid, children);
			children.setCaseNum(applicationEntity);
			childrenRepo.save(children);
		}
		
		return true;
	}

	@Override
	public DCSummary dcSummary(Integer caseNum) {
		 Optional<ApplicationEntity> optional=applicationRepo.findById(caseNum);
		if(optional.isPresent()) {
			ApplicationEntity entity=optional.get();	
			DcIncome income=entity.getIncomeDetails();
			DcEducation education=entity.getEducationDetails();
			List<DcChildren> kids=entity.getChildernDetails();
			
			DCSummary summary=new DCSummary();
			
			
			return summary;
		}
		
		return null;
	}

}
