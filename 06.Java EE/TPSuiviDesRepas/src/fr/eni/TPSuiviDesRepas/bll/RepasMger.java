package fr.eni.TPSuiviDesRepas.bll;

import java.util.List;

import fr.eni.TPSuiviDesRepas.bo.Repas;
import fr.eni.TPSuiviDesRepas.dal.DALException;
import fr.eni.TPSuiviDesRepas.dal.DAOFactory;
import fr.eni.TPSuiviDesRepas.dal.RepasDAO;

public class RepasMger {

	RepasDAO daorepas = DAOFactory.getDAORepas();
	
	public void ajouterRepas(Repas repas) throws BLLException {
		if(repas==null) {
			throw new BLLException("Ajouter : repas null");
		}
		try {
			daorepas.insert(repas);
		} catch (DALException e) {
			throw new BLLException("Ajouter", e);
		}
	}
	
	public List<Repas> selectionRepas() throws BLLException{
		List<Repas> liste = null;	
		try {
				liste = daorepas.selectAll();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return liste;
	}
}
