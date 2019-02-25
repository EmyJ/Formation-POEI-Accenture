/**
 * 
 */
package fr.eni.tpGestionListesCourses.dal;

import java.util.List;

import fr.eni.tpGestionListesCourses.BusinessException;
import fr.eni.tpGestionListesCourses.bo.Article;
import fr.eni.tpGestionListesCourses.bo.Liste;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version TPGestionListesCourses - V1.0
 * @date 4 févr. 2019 - 17:03:26
 */
public interface ListeDAO {

    public void insert(Liste liste) throws BusinessException;

    public List<Liste> select() throws BusinessException;

    public List<Liste> selectId(int id) throws BusinessException;

    public void update(Liste liste) throws BusinessException;
    
    public void delete(int id) throws BusinessException;

}
