package com.project.springmvc.model;

public class AdminPojo {

	private Integer adminId;


	private String adminEmailId;


	private String adminName;

	private String adminPassword;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public AdminPojo(Integer adminId, String adminEmailId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminEmailId = adminEmailId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "AdminPojo [adminId=" + adminId + ", adminEmailId=" + adminEmailId + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + "]";
	}

	public AdminPojo() {
	
	}
	
	
	
}
