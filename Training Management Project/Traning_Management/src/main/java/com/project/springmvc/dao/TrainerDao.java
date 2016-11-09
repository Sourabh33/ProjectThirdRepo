/**
 * 
 */
package com.project.springmvc.dao;

import java.util.List;

import com.project.springmvc.model.Trainer;
/**
 * @author vivekna
 *
 */
public interface TrainerDao 
{
	public boolean addTrainer(Trainer trainer) throws Exception;
	public Trainer getTrainerById(long id) throws Exception;
	public List<Trainer> getTrainerList() throws Exception;
	public boolean deleteTrainer(long id) throws Exception;

}
