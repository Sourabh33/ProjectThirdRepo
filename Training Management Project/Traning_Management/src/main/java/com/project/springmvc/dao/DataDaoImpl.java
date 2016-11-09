package com.project.springmvc.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.springmvc.model.Trainertester;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addEntity(Trainertester trainer) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(trainer);
		tx.commit();
		session.close();

		return false;
	}

	public Trainertester getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Trainertester trainer = (Trainertester) session.load(Trainertester.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return trainer;
	}

	@SuppressWarnings("unchecked")
	public List<Trainertester> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Trainertester> trainerList = session.createCriteria(Trainertester.class)
				.list();
		tx.commit();
		session.close();
		return trainerList;
	}

	public boolean deleteEntity(long id)throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Trainertester.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}



}
