/**
 * 
 */
package fr.eni.fighters.dal;

import java.util.List;

import fr.eni.fighters.BusinessException;
import fr.eni.fighters.bo.Carte;

/**
 * Interface pour l'implémentation des cartes
 * @author ejezeque2018
 * @version DigiFighters - V1.0
 * @date 12 févr. 2019 - 15:39:43
 */
public interface CarteDAO {
    
    public void cocherCarte(int idCarte) throws BusinessException;
    public void decocherCarte(int idCarte) throws BusinessException;
    public void decocherToutLesCartes(int idUser) throws BusinessException; 
    public List<Carte> selectAll(int id) throws BusinessException;
    public int countCocherCarte(int idUser) throws BusinessException;
    public List<Carte> selectPaquet(int idUser) throws BusinessException;
}
