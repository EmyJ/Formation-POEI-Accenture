/**
 * 
 */
package fr.eni.fighters.bll;

import java.util.List;

import fr.eni.fighters.BusinessException;
import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.dal.CarteDAO;
import fr.eni.fighters.dal.DAOFactory;

/**
 * Classe en charge de manipuler les données des cartes
 * 
 * @author ejezeque2018
 * @version DigiFighters - V1.0
 * @date 12 fÃ©vr. 2019 - 16:20:15
 */
public class CarteMger {

    CarteDAO daoCarte = DAOFactory.getDAOCarte();

    // Singleton
    private static CarteMger instance;
    private CarteMger() {
    }
    public static CarteMger getCarteMger() {
    	if (instance == null) {
    	    instance = new CarteMger();
    	}
    	return instance;
        }
    /*
     * permet de cocher une carte de la collection pour la mettre dans le paquet
     */
    public void cocherCarte(int idCarte) throws BusinessException {
	this.daoCarte.cocherCarte(idCarte);
    }
    
    /*
     * permet de décocher une carte de la collection pour la mettre dans le paquet
     */
    public void decocherCarte(int idCarte) throws BusinessException {
	this.daoCarte.decocherCarte(idCarte);
    }
    
    /*
     * permet de décocher toutes les cartes de la collection
     */
    public void decocherToutLesCartes(int idUser) throws BusinessException {
	this.daoCarte.decocherToutLesCartes(idUser);
    }
    
    /*
     * permet de récupérer toutes les cartes de la collection de l'utilisateur
     */
    public List<Carte> selectAll(int idUser) throws BusinessException {
	return this.daoCarte.selectAll(idUser);
    }
    
    /*
     * permet de compter le nombre de cartes cochées pour s'assurer que le paquet fait exactement 5 cartes
     */
    public int countCocherCarte(int idUser) throws BusinessException {
	return this.daoCarte.countCocherCarte(idUser);
    }
    
    /*
     * permet de sélectionner les 5 cartes cochées (celles qui constituent le paquet)
     */
    public List<Carte> selectPaquet(int idUser) throws BusinessException {
    	return this.daoCarte.selectPaquet(idUser);
        }
    
}
