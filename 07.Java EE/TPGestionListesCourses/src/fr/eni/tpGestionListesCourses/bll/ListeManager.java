/**
 * 
 */
package fr.eni.tpGestionListesCourses.bll;

import java.util.List;

import fr.eni.tpGestionListesCourses.BusinessException;
import fr.eni.tpGestionListesCourses.bo.Article;
import fr.eni.tpGestionListesCourses.bo.Liste;
import fr.eni.tpGestionListesCourses.dal.DAOFactory;
import fr.eni.tpGestionListesCourses.dal.ListeDAO;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version TPGestionListesCourses - V1.0
 * @date 5 févr. 2019 - 08:54:36
 */
public class ListeManager {

    private ListeDAO listeDAO;

    public ListeManager() {
	this.listeDAO = DAOFactory.getListeDAO();
    }

    public Liste ajouterListe(String nom, List<String> listeArticles) throws BusinessException {

	BusinessException businessException = new BusinessException();
	this.validerListeArticle(listeArticles, businessException);

	Liste liste = null;

	if (!businessException.hasErreurs()) {
	    liste = new Liste();
	    liste.setNom(nom);
	    for (String article : listeArticles) {
		liste.getArticles().add(new Article(article));
	    }
	    this.listeDAO.insert(liste);
	} else {
	    throw businessException;
	}
	return liste;
    }

    private void validerListeArticle(List<String> listeArticles, BusinessException businessException) {
	if (listeArticles == null || listeArticles.size() == 0) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_LISTE_ARTICLE_ERREUR);
	} else {
	    for (String article : listeArticles) {
		if (article.length() > 50) {
		    businessException.ajouterErreur(CodesResultatBLL.REGLE_LISTE_ARTICLE_ERREUR);
		    break;
		}
	    }
	}
    }

    public List<Liste> selectionnerTousLesListe() throws BusinessException {
	return this.listeDAO.select();
    }

    public List<Liste> selectId(int id) throws BusinessException {
	return this.listeDAO.selectId(id);
    }
    
    public void delete(int id) throws BusinessException {
	this.listeDAO.delete(id);
    }
    
}
