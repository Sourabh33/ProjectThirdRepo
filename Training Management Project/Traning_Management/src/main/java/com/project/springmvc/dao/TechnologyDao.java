package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.Technology;

public interface TechnologyDao 
{
	public boolean addTechnology(Technology technology) throws Exception;
	public Technology getTechnologyById(long id) throws Exception;
	public List<Technology> getTechnologyList() throws Exception;
	public boolean deleteTechnology(long id) throws Exception;
}
