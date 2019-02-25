/**
 * 
 */
package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

/**
 * @author Eni Ecole
 *
 */
public interface ArticleDAO extends DAOGeneric<Article, Integer, String>{
	
	//Sélectionner les articles par marque
	public List<Article> selectByMarque(String marque) throws DALException;
	
	//Sélectionner les articles par mot clé
	//On recherche le mot clé dans la désignation et la marque
	public List<Article> selectByMotCle(String motCle) throws DALException;

}
