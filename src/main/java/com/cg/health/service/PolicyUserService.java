package com.cg.health.service;

import java.util.List;

import com.cg.health.entities.PolicyUser;
import com.cg.health.exception.PolicyUserAlreadyExistsException;
import com.cg.health.exception.PolicyUserNotFoundException;

public interface PolicyUserService {
	

	public List<PolicyUser> getUsers() throws PolicyUserNotFoundException;

	public PolicyUser addUser(PolicyUser user)throws PolicyUserAlreadyExistsException;

	public PolicyUser getPolicyUserById(int policyUserId) throws PolicyUserNotFoundException;
}
