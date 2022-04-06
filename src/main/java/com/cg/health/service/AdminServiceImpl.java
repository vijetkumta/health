package com.cg.health.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.health.dao.AdminDao;
import com.cg.health.entities.Admin;
import com.cg.health.entities.Policy;
import com.cg.health.exception.AdminAlreadyExistsException;
import com.cg.health.exception.AdminNotFoundException;
import com.cg.health.exception.PolicyAlreadyExistsException;
import com.cg.health.exception.PolicyNotFoundException;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Admin> getAdmin() throws AdminNotFoundException {
		// TODO Auto-generated method stub
		return adminDao.findAll();
	}
@Transactional
	@Override
	public Admin addAdmin(Admin admin) throws AdminAlreadyExistsException {
	 if (adminDao.existsById(admin.getAdminId())) {
         throw new AdminAlreadyExistsException();
     }
     Admin savedAdmin = adminDao.save(admin);
     return savedAdmin;
 }
	

	@Override
	public Admin getAdminById(int adminId) throws AdminNotFoundException{
		 Admin admin;
	        if (adminDao.findById(adminId).isEmpty()) {
	            throw new AdminNotFoundException();
	        } else {
	            admin = adminDao.findById(adminId).get();
	        }
	        return admin;
	    }
		

	

}
