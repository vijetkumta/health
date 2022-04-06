package com.cg.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.health.entities.PolicyUser;
import com.cg.health.service.PolicyUserService;
import com.google.common.net.MediaType;

@RestController
@RequestMapping("/health")
public class PolicyUserController {
	@Autowired
	public PolicyUserService userService;
	@GetMapping("/InsuranceUser")
	public List<PolicyUser> getUsers(){
		return userService.getUsers() ;
	}
	@PostMapping("/InsuranceUser")
	public PolicyUser addUser(@RequestBody PolicyUser user){
		return userService.addUser(user);
	}
	@GetMapping(value="/InsuranceUser/{userId}")
	public ResponseEntity<PolicyUser> getPolicyUserById(@PathVariable int userId){
		PolicyUser policyUser1= userService.getPolicyUserById(userId);
		if(policyUser1==null)
		{
			return new ResponseEntity("Sorry! Policy not available!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PolicyUser>(policyUser1, HttpStatus.OK);
	
	}
}

//validate/login policyUser