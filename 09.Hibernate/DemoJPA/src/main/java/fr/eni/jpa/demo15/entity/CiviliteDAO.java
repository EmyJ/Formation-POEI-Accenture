package fr.eni.jpa.demo15.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.exception.DAOException;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 11:10:00
 */
public class CiviliteDAO {

    public static void add(Civilite c) throws DAOException {
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();

	try {
	    et.begin();
	    em.persist(c);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de l'ajout de la civilite " + c + " : " + e.getMessage());
	}
    }

    public static List<Civilite> findAll() {
	String requete = "SELECT Object(c) FROM Civilite c";
	return DAOUtil.getEntityManager().createQuery(requete, Civilite.class).getResultList();
    }

    public static Civilite findById(String id) {
	return DAOUtil.getEntityManager().find(Civilite.class, id);
    }
}
