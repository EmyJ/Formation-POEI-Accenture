/**
 * 
 */
package fr.eni.tpGestionListesCourses.dal;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version TPGestionListesCourses - V1.0
 * @date 4 févr. 2019 - 17:04:39
 */
public abstract class DAOFactory {

    public static ListeDAO getListeDAO() {
	return new ListeDAOJdbcImpl();
    }
}
