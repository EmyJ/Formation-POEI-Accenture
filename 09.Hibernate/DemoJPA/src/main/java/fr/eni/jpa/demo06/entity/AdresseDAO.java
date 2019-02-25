package fr.eni.jpa.demo06.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo06.entity.Adresse;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:18:35
 */
public class AdresseDAO {
    
    public Adresse findById(int id) {
	return DAOUtil.getEntityManager().find(Adresse.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Adresse> findAll(){
	String requete ="select Object(a) from Adresse0T0 a";
	return DAOUtil.getEntityManager().createQuery(requete).getResultList();
    }
    
    public void add(Adresse a) throws Exception{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.persist(a);
	    et.commit();
	} catch (Exception e) { 
	    et.rollback();
	    throw e;
	}
    }
    
    public void delete(Adresse a) throws Exception{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.remove(a);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw e;
	}
    }
    
    public void update(Adresse a) throws Exception{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.merge(a);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw e;
	}
    }
}
