package com.cg.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.health.dao.PolicyPurchaseDao;
import com.cg.health.entities.Policy;
import com.cg.health.entities.PolicyPurchase;
import com.cg.health.exception.PolicyAlreadyExistsException;
import com.cg.health.exception.PolicyNotFoundException;
import com.cg.health.exception.PolicyPurchaseAlreadyExistsException;
import com.cg.health.exception.PolicyPurchaseNotFoundException;

@Service
public class PolicyPurchaseServiceImpl implements PolicyPurchaseService {

	@Autowired
	private PolicyPurchaseDao policyPurchaseDao;
	
	

	@Override
	public PolicyPurchase addPolicyPurchase(PolicyPurchase policyPurchase)throws PolicyPurchaseAlreadyExistsException {
		if (policyPurchaseDao.existsById(policyPurchase.getPolicyPurchaseId())) {
            throw new PolicyPurchaseAlreadyExistsException();
        }
        PolicyPurchase savedPolicyPurchase = policyPurchaseDao.save(policyPurchase);
        return savedPolicyPurchase;
		//return policyPurchaseDao.save(policyPurchase);
	}

	@Override
	public PolicyPurchase getPolicyPurchaseUserById(long policyPurchaseUserId) throws PolicyPurchaseNotFoundException {
		// TODO Auto-generated method stub
		  PolicyPurchase policyPurchase;
	        if (policyPurchaseDao.findById(policyPurchaseUserId).isEmpty()) {
	            throw new PolicyPurchaseNotFoundException();
	        } else {
	            policyPurchase = policyPurchaseDao.findById(policyPurchaseUserId).get();
	        }
	        return policyPurchase;
	    }
		//return policyPurchaseDao.getById(policyPurchaseUserId);
	

	@Override
	public double calculatePrimium(int age, float payingTerm, double sumAssured, float policyTerm) {
		// TODO Auto-generated method stub
		return 0;
	}

		@Override
		public List<PolicyPurchase> getPolicyPurchase() throws PolicyPurchaseNotFoundException {
			
			return policyPurchaseDao.findAll();
		}

}
