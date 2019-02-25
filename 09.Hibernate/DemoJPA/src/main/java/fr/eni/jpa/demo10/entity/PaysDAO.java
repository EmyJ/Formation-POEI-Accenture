package fr.eni.jpa.demo10.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.exception.DAOException;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 12:10:54
 */
public class PaysDAO {
    
    public static void add(Pays p) throws DAOException {
   	EntityManager em = DAOUtil.getEntityManager();
   	EntityTransaction et = em.getTransaction();

   	try {
   	    et.begin();
   	    em.persist(p);
   	    et.commit();
   	} catch (Exception e) {
   	    et.rollback();
   	    throw new DAOException("Erreur lors de l'ajout du pays " + p + " : " + e.getMessage());
   	}
       }

       public static void delete(Pays p) throws DAOException {
   	EntityManager em = DAOUtil.getEntityManager();
   	EntityTransaction et = em.getTransaction();

   	try {
   	    et.begin();
   	    em.remove(p);
   	    et.commit();
   	} catch (Exception e) {
   	    et.rollback();
   	    throw new DAOException("Erreur lors de la suppression du pays " + p + " : " + e.getMessage());
   	}
       }

       public static void update(Pays p) throws DAOException {
   	EntityManager em = DAOUtil.getEntityManager();
   	EntityTransaction et = em.getTransaction();

   	try {
   	    et.begin();
   	    em.merge(p);
   	    et.commit();
   	} catch (Exception e) {
   	    et.rollback();
   	    throw new DAOException("Erreur lors de la modification du pays " + p + " : " + e.getMessage());
   	}
       }

       public static List<Pays> findAll() {
   	String requete = "SELECT Object(p) FROM PaysMTM p";
   	return DAOUtil.getEntityManager().createQuery(requete, Pays.class).getResultList();
       }

       public static Pays findById(String id) {
   	return DAOUtil.getEntityManager().find(Pays.class, id);
       }
    
}
