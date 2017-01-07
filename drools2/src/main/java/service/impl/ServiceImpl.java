package main.java.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import main.java.dao.Dao;
import main.java.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl<T, ID extends Serializable> implements Service<T, ID>{

	@Autowired
	private Dao<T, ID> dao;

	@Transactional
	public void add(T tp) {
		// TODO Auto-generated method stub
		dao.add(tp);
		
	}

	@Transactional
	public void update(T tp) {
		// TODO Auto-generated method stub
		dao.update(tp);
	}

	@Transactional
	public void delete(ID id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Transactional
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Transactional
	public List<T> getAll(String table) {
		// TODO Auto-generated method stub
		return dao.getAll(table);
	}
}
