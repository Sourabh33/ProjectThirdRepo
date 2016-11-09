package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.model.Batch;

public class BatchDaoImpl implements BatchDao
{
	@Autowired
	SessionFactory sessionFactory;	
	Session session = null;
	Transaction tx = null;

	public boolean addBatch(Batch batch) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(batch);
		tx.commit();
		session.close();

		return false;
	}

	public Batch getBatchById(long id) throws Exception {
		session = sessionFactory.openSession();
		Batch batch = (Batch) session.load(Batch.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return batch;
	}

	@SuppressWarnings("unchecked")
	public List<Batch> getBatchList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Batch> batchList = session.createCriteria(Batch.class)
				.list();
		tx.commit();
		session.close();
		return batchList;
	}

	public boolean deleteBatch(long id)throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Batch.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
