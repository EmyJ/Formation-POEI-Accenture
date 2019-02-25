package fr.eni.TPSuiviDesRepas.dal;

import fr.eni.TPSuiviDesRepas.dal.sqlserver.RepasDAOSqlServerImpl;

public class DAOFactory {

	public static RepasDAO getDAORepas() {
		return new RepasDAOSqlServerImpl(); 
	}
	
}
