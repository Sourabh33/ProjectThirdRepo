package com.project.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.model.Trainer;



public class TrainerDaoImpl implements TrainerDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;

	public boolean addTrainer(Trainer trainer) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(trainer);
		tx.commit();
		session.close();

		return false;
	}

	public Trainer getTrainerById(long id) throws Exception {
		session = sessionFactory.openSession();
		Trainer trainer = (Trainer) session.load(Trainer.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return trainer;
	}

	@SuppressWarnings("unchecked")
	public List<Trainer> getTrainerList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Trainer> trainerList = session.createCriteria(Trainer.class)
				.list();
		tx.commit();
		session.close();
		return trainerList;
	}

	public boolean deleteTrainer(long id)throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Trainer.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}



}
