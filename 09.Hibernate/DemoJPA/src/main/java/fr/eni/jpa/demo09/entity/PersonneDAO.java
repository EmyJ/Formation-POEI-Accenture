package fr.eni.jpa.demo09.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo09.entity.Personne;
import fr.eni.jpa.exception.DAOException;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:18:35
 */
public class PersonneDAO {

    public static void add(Personne p) throws DAOException {
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();

	try {
	    et.begin();
	    em.persist(p);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de l'ajout de la personne " + p + " : " + e.getMessage());
	}
    }

    public static void deleteAll() throws DAOException {
	String requete = "DELETE FROM Personne p";
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();

	try {
	    et.begin();
	    em.createQuery(requete).executeUpdate();
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la suppression de toutes les personnes " + " : " + e.getMessage());
	}
    }

    public static void delete(Personne p) throws DAOException {
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();

	try {
	    et.begin();
	    em.remove(p);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la suppression de la personne " + p + " : " + e.getMessage());
	}
    }

    public static void update(Personne p) throws DAOException {
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();

	try {
	    et.begin();
	    em.merge(p);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la modification de la personne " + p + " : " + e.getMessage());
	}
    }

    public static List<Personne> findAll() {
	String requete = "SELECT Object(p) FROM PersonneMTO p";
	return DAOUtil.getEntityManager().createQuery(requete, Personne.class).getResultList();
    }

    public static Personne findById(int id) {
	return DAOUtil.getEntityManager().find(Personne.class, id);
    }
}
