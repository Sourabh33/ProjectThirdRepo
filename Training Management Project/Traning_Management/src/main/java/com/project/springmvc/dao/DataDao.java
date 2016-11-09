package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.Trainertester;

public interface DataDao {

	public boolean addEntity(Trainertester trainer) throws Exception;
	public Trainertester getEntityById(long id) throws Exception;
	public List<Trainertester> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	
}
