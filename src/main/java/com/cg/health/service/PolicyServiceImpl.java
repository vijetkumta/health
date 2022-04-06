package com.cg.health.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.health.dao.PolicyDao;
import com.cg.health.entities.Policy;
import com.cg.health.exception.BadRequestException;
import com.cg.health.exception.PolicyAlreadyExistsException;
import com.cg.health.exception.PolicyNotFoundException;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyDao policyDao;


//	@Override
//	public List<Policy> getPolicies() {
//		
//		return policyDao.findAll();
//	}
//
//	@Override
//	public Policy addPolicies(Policy policy) {
//		
//	return	policyDao.save(policy);
//
//	}
//
//	  @Override
//	    public Policy getPolicyById(int policyId) {
//	      return policyDao.findById(policyId).get();
//	    }
	  
	  
	  @Override
	    public Policy addPolicies(Policy policy) throws PolicyAlreadyExistsException,BadRequestException {
	        if (policyDao.existsById(policy.getPolicyId())) {
	            throw new PolicyAlreadyExistsException();
	        }
	        Policy savedPolicy = policyDao.save(policy);
	        return savedPolicy;
	    }
	    @Override
	    public List<Policy>  getPolicies() throws PolicyNotFoundException,BadRequestException {
	    	 
	        return  policyDao.findAll();
	    }
	    
	    @Override
	    public Policy getPolicyById(int policyId) throws PolicyNotFoundException,BadRequestException {
	        Policy policy;
	        if (policyDao.findById(policyId).isEmpty()) {
	            throw new PolicyNotFoundException();
	        } else {
	            policy = policyDao.findById(policyId).get();
	        }
	        return policy;
	    }
	}
	

