package fr.eni.module04.dal;

import fr.eni.module04.dal.sqlserver.AvisDAOSqlServerImpl;

public class DAOFactory {

	public static AvisDAO getDAOAvis() {
		return new AvisDAOSqlServerImpl(); 
	}
	
}
