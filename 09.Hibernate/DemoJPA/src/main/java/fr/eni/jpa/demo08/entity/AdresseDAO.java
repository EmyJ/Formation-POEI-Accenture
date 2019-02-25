package fr.eni.jpa.demo08.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo08.entity.Adresse;
import fr.eni.jpa.exception.DAOException;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:18:35
 */
public class AdresseDAO {
    
    public static Adresse findById(int id) {
	return DAOUtil.getEntityManager().find(Adresse.class, id);
    }

    @SuppressWarnings("unchecked")
    public static List<Adresse> findAll(){
	String requete ="select Object(a) from Adresse0T0MBi a";
	return DAOUtil.getEntityManager().createQuery(requete).getResultList();
    }
    
    public static void add(Adresse a) throws DAOException{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.persist(a);
	    et.commit();
	} catch (Exception e) { 
	    et.rollback();
	    throw new DAOException("Erreur lors de l'ajout de l'adresse " + a + " : " + e.getMessage());
	}
    }
    
    public static void delete(Adresse a) throws DAOException{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.remove(a);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la suppression de l'adresse " + a + " : " + e.getMessage());
	}
    }
    
    public static void update(Adresse a) throws DAOException{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.merge(a);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la modification de l'adresse " + a + " : " + e.getMessage());
	}
    }
}
