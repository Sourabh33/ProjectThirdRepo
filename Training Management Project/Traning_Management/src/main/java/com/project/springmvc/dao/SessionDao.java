package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.TMSSession;

public interface SessionDao 
{
	public boolean addSession(TMSSession session) throws Exception;
	public TMSSession getSessionById(long id) throws Exception;
	public List<TMSSession> getSessionList() throws Exception;
	public boolean deleteSession(long id) throws Exception;
}
