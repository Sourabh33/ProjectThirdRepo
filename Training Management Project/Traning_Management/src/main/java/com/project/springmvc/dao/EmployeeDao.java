package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.Employee;

public interface EmployeeDao 
{
	public boolean addEmployee(Employee employee) throws Exception;
	public Employee getEmployeeById(long id) throws Exception;
	public List<Employee> getEmployeeList() throws Exception;
	public boolean deleteEmployee(long id) throws Exception;
}
