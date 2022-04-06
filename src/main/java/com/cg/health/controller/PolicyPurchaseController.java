package com.cg.health.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.health.entities.PolicyPurchase;
import com.cg.health.entities.PolicyPurchase;
import com.cg.health.service.PolicyPurchaseService;

@RestController
@RequestMapping("/health")
public class PolicyPurchaseController {
	@Autowired
	public PolicyPurchaseService policyPurchaseService;
	
	@GetMapping(value="/policyPurchase", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<PolicyPurchase>> getPolicyPurchaseList(){
		 List<PolicyPurchase> policyPurchaselist=policyPurchaseService.getPolicyPurchase();
		 if(policyPurchaselist.isEmpty())
		 {
			 return new ResponseEntity("Sorry! PoicyPurchase not available!",
					 HttpStatus.NOT_FOUND);
		 }
		 
		 return new ResponseEntity<List<PolicyPurchase>>(policyPurchaselist, HttpStatus.OK);
	}
	@PostMapping("/policyPurchase")
	public ResponseEntity<PolicyPurchase> addPolicyPurchase(@RequestBody PolicyPurchase policyPurchase1){
	//	Date endDate=policyPurchase1.getPurchaseDate()+policyPurchase1.getPolicyPuchaseDuration();
		LocalDate startDate=policyPurchase1.getPurchaseDate();
		policyPurchase1.setPurchaseEndDate(startDate.plusYears(policyPurchase1.getPolicyPuchaseDuration()));
		int age =LocalDate.now().getYear()- policyPurchase1.getPolicyUser().getDob().getYear();
		float payingTerm=policyPurchase1.getPolicyPuchaseDuration();
		double sumAssured=policyPurchase1.getPolicy().getPolicyCost();
		float policyTerm=policyPurchase1.getPolicy().getPolicyDurationInYear();
		policyPurchase1.setPremiumAmount(policyPurchaseService.calculatePrimium(age,payingTerm , sumAssured, policyTerm));
		PolicyPurchase policyPurchase2= policyPurchaseService.addPolicyPurchase(policyPurchase1);
		if(policyPurchase2==null)
		{
			return new ResponseEntity("Sorry! Admin not available!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PolicyPurchase>(policyPurchase2, HttpStatus.OK);
	}
	@GetMapping(value="/policyPurchase/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PolicyPurchase>getPolicyPurchaseById(@PathVariable int id){
		PolicyPurchase policyPurchase1= policyPurchaseService.getPolicyPurchaseUserById(id);
		if(policyPurchase1==null)
		{
			return new ResponseEntity("Sorry! Admin not available!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PolicyPurchase>(policyPurchase1, HttpStatus.OK);
	}
	//public double calculatePrimium()
// buyPolicy by user
// renew policy purchased
// getAllPolicies by userId
// getCurrentPolicy by userId	
}
