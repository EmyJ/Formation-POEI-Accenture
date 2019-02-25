/**
 * 
 */
package fr.eni.fighters.bll;

import java.util.List;

import fr.eni.fighters.BusinessException;
import fr.eni.fighters.dal.DALException;
import fr.eni.fighters.bo.User;
import fr.eni.fighters.dal.DAOFactory;
import fr.eni.fighters.dal.UserDAO;

/**
 * Classe pour manipuler les données sur les utilisateurs
 * 
 * @author agrimonp2018
 * @date 11 févr. 2019
 */
public class UserMger {

    UserDAO daoUser = DAOFactory.getDAOUser();

    // Singleton
    private static UserMger instance;
    private UserMger() {
    }
    public static UserMger getUSerMger() {
	if (instance == null) {
	    instance = new UserMger();
	}
	return instance;
    }

    /*
     * Permet d'ajouter un user en BDD
     */
    public void ajouterUser(User user) throws BusinessException {
	BusinessException businessException = new BusinessException();

	if (!businessException.hasErreurs()) {
	    try {
		daoUser.insert(user);
	    } catch (DALException e) {
		e.printStackTrace();
	    }
	} else {
	    throw businessException;
	}
    }

    /*
     * Permet de supprimer un user par son id
     */
    public void supprimerUser(int id) throws BusinessException {
	BusinessException businessException = new BusinessException();

	if (!businessException.hasErreurs()) {
	    try {
		daoUser.delete(id);
	    } catch (DALException e) {
		e.printStackTrace();
	    }
	} else {
	    throw businessException;
	}
    }

    /*
     * Permet de sélectionner un user par son Id
     */
    public User selectById(int id) throws BusinessException {
	User user = null;
	try {
	    user = daoUser.selectById(id);
	} catch (DALException e) {
	    e.printStackTrace();
	}

	return user;
    }

    /*
     * Permet d'afficher toutes les users
     */
    public List<User> selectionUsers() throws BusinessException {
	List<User> listeTotal = null;
	try {
	    listeTotal = daoUser.selectAll();
	} catch (DALException e) {
	    e.printStackTrace();
	}

	return listeTotal;

    }

    /*
     * Permet de modifier l'user
     */
    public void updateUser(User user) throws BusinessException {
	BusinessException businessException = new BusinessException();

	if (!businessException.hasErreurs()) {
	    try {
		daoUser.update(user);
	    } catch (DALException e) {
		e.printStackTrace();
	    }
	} else {
	    throw businessException;
	}
    }
}
