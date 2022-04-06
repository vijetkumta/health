package com.cg.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.health.dao.PolicyUserDao;
import com.cg.health.entities.PolicyUser;
import com.cg.health.exception.PolicyNotFoundException;
import com.cg.health.exception.PolicyUserAlreadyExistsException;
import com.cg.health.exception.PolicyUserNotFoundException;

@Service
public class PolicyUserServiceImpl implements PolicyUserService {
	
    @Autowired
	private PolicyUserDao userDao; 
	@Override
	public List<PolicyUser> getUsers() throws PolicyUserNotFoundException {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	@Override
	public PolicyUser addUser(PolicyUser user) throws PolicyUserAlreadyExistsException{
		if(userDao.existsById(user.getUserId())) {
			throw new PolicyUserAlreadyExistsException();
		}
		return userDao.save(user);
	}
	@Override
	public PolicyUser getPolicyUserById(int policyUserId) throws PolicyUserNotFoundException {
		if (userDao.findById(policyUserId).isEmpty()) {
            throw new PolicyNotFoundException();
        } 

		return userDao.findById(policyUserId).get();
	}
 
	
}
