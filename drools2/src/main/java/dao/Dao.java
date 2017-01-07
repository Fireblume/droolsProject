package main.java.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, ID extends Serializable> {

	public void add(T tp);
	public void update(T tp);
	public void delete(ID id, T classT);
	public T findById(ID id, T classT);
	public List<T> getAll(String table);
}
