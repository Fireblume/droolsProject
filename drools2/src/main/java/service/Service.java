package main.java.service;

import java.io.Serializable;
import java.util.List;

public interface Service <T, ID extends Serializable> {

	public void add(T tp);
	public void update(T tp);
	public void delete(ID id);
	public T findById(ID id);
	public List<T> getAll(String table);
}
