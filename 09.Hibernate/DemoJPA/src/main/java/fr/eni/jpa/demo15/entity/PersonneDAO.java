package fr.eni.jpa.demo15.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo15.entity.Personne;
import fr.eni.jpa.exception.DAOException;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:18:35
 */
public class PersonneDAO {

    public static List<Personne> findTous(){
	TypedQuery<Personne> query = DAOUtil.getEntityManager().createNamedQuery("findTous", Personne.class);
	return query.getResultList();
    }
    
    public static List<Personne> findNomCommencePar(String debut){
	TypedQuery<Personne> query = DAOUtil.getEntityManager().createNamedQuery("findNomCommencePar", Personne.class);
	return query.setParameter("var", debut + "%").getResultList();
    }
    
    public static List<Personne> findMessieurs(){
	TypedQuery<Personne> query = DAOUtil.getEntityManager().createNamedQuery("findMessieurs", Personne.class);
	return query.getResultList();
    }

    public static Personne findByQuery(int id) {
	TypedQuery<Personne> query = DAOUtil.getEntityManager().createQuery("SELECT p FROM Personne15 p WHERE p.id = :id", Personne.class);
	query.setParameter("id", id);
	Personne p = query.getSingleResult();
	return p;
    }

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
}
