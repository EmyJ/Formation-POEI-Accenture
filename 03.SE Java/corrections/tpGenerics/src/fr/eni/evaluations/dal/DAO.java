package fr.eni.evaluations.dal;

import java.util.List;

public interface DAO <T>{

	public void insert(T data) throws Exception;
	public void update(T data) throws Exception;	
	public void delete(T data) throws Exception;
	public T selectById(int id) throws Exception;
	public List<T> selectAll() throws Exception;
}
