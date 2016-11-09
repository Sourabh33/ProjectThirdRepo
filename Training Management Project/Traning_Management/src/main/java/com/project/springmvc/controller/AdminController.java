package com.project.springmvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.project.springmvc.model.Admin;
import com.project.springmvc.model.AdminPojo;
import com.project.springmvc.service.AdminService;

@RestController
public class AdminController {
	

		@Autowired
		AdminService adminServices;

	
		@RequestMapping(value = "/admin/list/", method = RequestMethod.GET)
		public ResponseEntity<List<Admin>> getAdminList() throws Exception {
			List<Admin> adminList = null;
		
				adminList = adminServices.findAllAdmins();
			
	       return new ResponseEntity<List<Admin>>(adminList, HttpStatus.OK);
		}
	
		@RequestMapping(value = "/admin/create/", method = RequestMethod.POST)
		public ResponseEntity<Void> addAdmin(@RequestBody AdminPojo admin, UriComponentsBuilder ucBuilder) {
			System.out.println(" in Creating requirement " + admin);
			Admin ad = new Admin();
			ad.setAdminEmailId(admin.getAdminEmailId());
			ad.setAdminName(admin.getAdminName());
			ad.setAdminPassword(admin.getAdminPassword());
			try {
				adminServices.addAdmin(ad);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		 @RequestMapping(value = "/admin/update/{id}", method = RequestMethod.PUT)
			public ResponseEntity<Admin> updateAdmin(@PathVariable("id") int id ,@RequestBody AdminPojo admin) throws Exception {
				System.out.println(" in updateRequirement " + admin);
				Admin ad = adminServices.findAdminById(id);
				if(ad==null)
				{
					 System.out.println("User with id " + id + " not found");
			            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
				}
				ad.setAdminEmailId(admin.getAdminEmailId());
				ad.setAdminName(admin.getAdminName());
				ad.setAdminPassword(admin.getAdminPassword());
				try {
					adminServices.updateAdmin(ad);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return new ResponseEntity<Admin>(ad, HttpStatus.OK);
			}

		 @RequestMapping(value = "/admin/detail/{id}", method = RequestMethod.POST)
			public ResponseEntity<Admin> getAdmin(@PathVariable("id") int id) throws Exception {
				
			 Admin admin = null;
			 try {
					admin = adminServices.getAdminById(id);

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		       return new ResponseEntity<Admin>(admin, HttpStatus.FOUND);
			}
		
		 
		 @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.DELETE)
		    public ResponseEntity<Admin> deleteAdmin(@PathVariable("id") int id) throws Exception {
		        
		        Admin admin = adminServices.getAdminById(id);
		        if (admin == null) {
		          
		            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		        }
		        adminServices.deleteAdmin(id);
		        return new ResponseEntity<Admin>(HttpStatus.OK);
		    }

	}

