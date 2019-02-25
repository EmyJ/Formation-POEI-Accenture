package fr.eni.papeterie.dal;

import java.util.List;


public interface DAOGeneric <T, E, S>{
	
	public void insert(T data) throws DALException;

	public T selectById(E id) throws DALException;
	
	public List<T> selectAll() throws DALException;
	
	public void update(T data) throws DALException;
	
	public void delete(E id) throws DALException;	
}
