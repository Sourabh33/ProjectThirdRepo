package com.project.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.AdminDao;
import com.project.springmvc.model.Admin;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin getAdminById(Integer id) throws Exception {
		return adminDao.getAdminById(id);
	}

	@Override
	public void addAdmin(Admin admin) throws Exception {
		adminDao.addAdmin(admin);
		
	}

	@Override
	public void updateAdmin(Admin admin) throws Exception {
		 Admin entity = adminDao.getAdminById(admin.getAdminId());
	        if(entity!=null){
	            entity.setAdminName(admin.getAdminName());
	            entity.setAdminEmailId(admin.getAdminEmailId());
	            entity.setAdminPassword(admin.getAdminPassword());
	        }
		
	}

	@Override
	public void deleteAdmin(Integer id) throws Exception {
		
		 adminDao.deleteAdmin(id);
		
	}

	@Override
	public List<Admin> findAllAdmins() throws Exception {
		return adminDao.getAdminList();
		
	}

	@Override
	public Admin findAdminById(Integer id) throws Exception {
		return adminDao.getAdminById(id);
	}

	@Override
	public Admin adminAuthentication(String uname, String pass) throws Exception {
		return adminDao.adminAuthentication(uname, pass);
	}

}
