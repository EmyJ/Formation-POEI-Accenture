package fr.eni.TPSuiviDesRepas.dal;

import java.util.List;

import fr.eni.TPSuiviDesRepas.bo.Repas;


public interface RepasDAO {
	
	void insert(Repas repas) throws DALException;
	List<Repas> selectAll() throws DALException;
}
