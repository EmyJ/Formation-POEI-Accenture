package fr.eni.jpa.demo06.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo06.entity.Personne;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:18:35
 */
public class PersonneDAO {
    
    public Personne findById(int id) {
	return DAOUtil.getEntityManager().find(Personne.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Personne> findAll(){
	String requete ="select Object(p) from Personne p";
	return DAOUtil.getEntityManager().createQuery(requete).getResultList();
    }
    
    public void add(Personne p) throws Exception{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.persist(p);
	    et.commit();
	} catch (Exception e) { 
	    et.rollback();
	    throw e;
	}
    }
    
    public void delete(Personne p) throws Exception{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.remove(p);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw e;
	}
    }
    
    public void update(Personne p) throws Exception{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.merge(p);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw e;
	}
    }
}
