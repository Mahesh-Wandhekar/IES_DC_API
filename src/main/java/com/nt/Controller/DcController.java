package com.nt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Bind.DCSummary;
import com.nt.Bind.Eduction;
import com.nt.Bind.Income;
import com.nt.Bind.Kids;
import com.nt.Bind.PlanSelection;
import com.nt.Service.DCService;

@RestController
public class DcController {

	@Autowired
	private DCService service;
	
	@GetMapping("/getplans")
	public List<String> getPlans(){
	 List<String> plans=service.getPlans();
		return plans;
	}
	
	@PostMapping("/planselc")
	public ResponseEntity<String> planSelection( @RequestBody PlanSelection selection){
		boolean status=service.planSelection(selection);
		if(status) {
			return new ResponseEntity<>("Plan Selection Success",HttpStatus.OK);
		}
		return new ResponseEntity<>("Plan Selection Failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/edu")
	public ResponseEntity<String> education(@RequestBody Eduction eduction){
		boolean status =service.eduction(eduction);
		if(status) {
			return new ResponseEntity<>("Eduction Details Added Success",HttpStatus.OK);
		}
		return new ResponseEntity<>("Eduction Details Added Failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PostMapping("/income")
	public ResponseEntity<String> income(@RequestBody Income income){
		boolean status=service.income(income);
		
		if(status) {
			return new ResponseEntity<>("Income Details Added Success",HttpStatus.OK);
		}
		return new ResponseEntity<>("Income Details Added Failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/kid")
	public ResponseEntity<String> kids(@RequestBody Kids kids){
		boolean status=service.kids(kids);
		if(status) {
			return new ResponseEntity<>("Childern Details Added Success",HttpStatus.OK);
		}
		return new ResponseEntity<>("Childern Details Added Failed",HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	
	@GetMapping("dc-summary/{id}")
	public ResponseEntity<DCSummary> dcSummary(@PathVariable("id") Integer  id){
		DCSummary summary=service.dcSummary(id);
		return new ResponseEntity<>(summary,HttpStatus.OK);
	}
	
}

