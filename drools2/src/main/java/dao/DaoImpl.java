package main.java.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl<T, ID extends Serializable> implements Dao<T, ID>{

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(T tp) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(tp);
	}

	@Override
	public void update(T tp) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(tp);
	}

	@Override
	public void delete(ID id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(findById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return (T)session.getCurrentSession().get((Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), DaoImpl.class), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(String table) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from " + table).list();
	}

}

