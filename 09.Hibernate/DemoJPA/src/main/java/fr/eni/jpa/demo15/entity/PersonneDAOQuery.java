package fr.eni.jpa.demo15.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo15.entity.Personne;
import fr.eni.jpa.exception.DAOException;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 21 févr. 2019 - 10:22:36
 */
public class PersonneDAOQuery {

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
	String requete = "SELECT Object(p) FROM Personne15 p";
	return DAOUtil.getEntityManager().createQuery(requete, Personne.class).getResultList();
    }

    public static Personne findById(int id) {
	return DAOUtil.getEntityManager().find(Personne.class, id);
    }

    @SuppressWarnings("unchecked")
    public static List<Personne> findLegrand() {
	EntityManager em = DAOUtil.getEntityManager();
	Query query = em.createQuery("SELECT p FROM Personne15 p WHERE p.nom = 'Legrand'");
	return query.getResultList();
    }

    public static List<Personne> findLepetit() {
	EntityManager em = DAOUtil.getEntityManager();
	TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne15 p WHERE p.nom = 'Lepetit'",
		Personne.class);
	return query.getResultList();
    }

    public static List<Personne> findByNom(String nom) {
	EntityManager em = DAOUtil.getEntityManager();
	TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne15 p WHERE p.nom = :nom", Personne.class);
	query.setParameter("nom", nom);
	return query.getResultList();
    }

    public static List<Personne> findByNom2(String nom) {
	EntityManager em = DAOUtil.getEntityManager();
	TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne15 p WHERE p.nom = ?1", Personne.class);
	query.setParameter(1, nom);
	return query.getResultList();
    }

    public static Personne findByIdQuery(int id) {
	EntityManager em = DAOUtil.getEntityManager();
	TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne15 p WHERE p.id = :id", Personne.class);
	query.setParameter("id", id);
	return query.getSingleResult();
    }

    public static long nombreDElements() {
	EntityManager em = DAOUtil.getEntityManager();
	TypedQuery<Long> query = em.createQuery("SELECT COUNT(p.id) FROM Personne15 p ", Long.class);
	return query.getSingleResult();
    }

    public static List<String> tousLesPrenom() {
	EntityManager em = DAOUtil.getEntityManager();
	TypedQuery<String> query = em.createQuery("SELECT p.prenom FROM Personne15 p ", String.class);
	return query.getResultList();
    }

    public static List<Personne> jointure() {
	EntityManager em = DAOUtil.getEntityManager();
	TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne15 p JOIN p.civilite c WHERE c.cle='Mlle'",
		Personne.class);
	return query.getResultList();
    }
    
    public static List<Personne> jointureAvecTri() {
	EntityManager em = DAOUtil.getEntityManager();
	TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne15 p JOIN p.civilite c ORDER BY c.libelle desc",
		Personne.class);
	return query.getResultList();
    }
    
   public static void suppresionLeGrand() throws DAOException{
       EntityManager em = DAOUtil.getEntityManager();
       EntityTransaction et = em.getTransaction();
       Query query = em.createQuery("DELETE FROM Personne15 p WHERE p.nom = 'Legrand'");
	try {
	    et.begin();
	    query.executeUpdate();
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la suppression des Legrand " + " : " + e.getMessage());
	}
   }
   
   public static void modifier(int id, String prenom) throws DAOException {
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	Query query = em.createQuery("UPDATE Personne15 p SET p.prenom = :prenom WHERE p.id = :id");
	query.setParameter("id", id);
	query.setParameter("prenom", prenom);
	try {
	    et.begin();
	    query.executeUpdate();
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la modification  " + " : " + e.getMessage());
	}
   }
}
