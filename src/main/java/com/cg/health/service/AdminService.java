package com.cg.health.service;

import java.util.List;

import com.cg.health.entities.Admin;
import com.cg.health.exception.AdminAlreadyExistsException;
import com.cg.health.exception.AdminNotFoundException;

public interface AdminService {

	public List<Admin> getAdmin() throws AdminNotFoundException;

	public Admin addAdmin(Admin admin) throws AdminAlreadyExistsException;

	public Admin getAdminById(int adminId) throws AdminNotFoundException;
}
