package fr.eni.module04.bll;

import fr.eni.module04.bo.Avis;
import fr.eni.module04.dal.AvisDAO;
import fr.eni.module04.dal.DALException;
import fr.eni.module04.dal.DAOFactory;
import fr.eni.module04.dal.sqlserver.AvisDAOSqlServerImpl;

public class AvisMger {

	//AvisDAOSqlServerImpl daoAvis = new AvisDAOSqlServerImpl();
	//AvisDao daoAvis = new AvisDAOSqlServerImpl();
	AvisDAO daoAvis = DAOFactory.getDAOAvis();
	
	public void ajouterAvis(Avis avis) throws BLLException {
		if(avis==null) {
			throw new BLLException("Ajouter : avis null");
		}
		try {
			daoAvis.insert(avis);
		} catch (DALException e) {
			throw new BLLException("Ajouter", e);
		}
	}
	
	
}
