package fr.eni.fighters.dal;

import fr.eni.fighters.dal.sqlserver.CarteDAOsqlServerImpl;
import fr.eni.fighters.dal.sqlserver.UserDAOsqlServerImpl;

/*
 * Créer des instances d'implémentation à la demande suivant le type d'objet à manipuler
 */
public class DAOFactory {
	
	public static UserDAO getDAOUser() {
		return new UserDAOsqlServerImpl();
	}
	
	public static CarteDAO getDAOCarte() {
	    return new CarteDAOsqlServerImpl();
	}
	
}
