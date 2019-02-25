package fr.eni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.eni.bean.Livre;
import fr.eni.Exception.DAOException;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version GestionLivre - V1.0
 * @date 21 févr. 2019 - 14:13:51
 */
public class LivreDAO {

    public static void add(Livre livre) throws DAOException{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();

	try {
	    et.begin();
	    em.persist(livre);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de l'ajout du livre " + livre + " : " + e.getMessage());
	}
    }
    
    public static void delete(Livre livre) throws DAOException{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaDelete<Livre> deleteQuery = cb.createCriteriaDelete(Livre.class);
	Root<Livre> l = deleteQuery.from(Livre.class);
	deleteQuery.where(cb.equal(l.get("id"), livre.getId()));
	try {
	    et.begin();
	    em.createQuery(deleteQuery).executeUpdate();
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la supperssion du livre " + livre + " : " + e.getMessage());
	}
    } 
    
    public static void update(Livre livre) throws DAOException{
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaUpdate<Livre> updateQuery = cb.createCriteriaUpdate(Livre.class);
	Root<Livre> l = updateQuery.from(Livre.class);
	updateQuery.set("id", livre.getId());
	updateQuery.where(cb.equal(l.get("id"), livre.getId()));
	try {
	    et.begin();
	    em.createQuery(updateQuery).executeUpdate();
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la modification du livre " + livre + " : " + e.getMessage());
	}
	
	
    }
    
    public static void delete(int id) throws DAOException {
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaDelete<Livre> deleteQuery = cb.createCriteriaDelete(Livre.class);
	Root<Livre> livre = deleteQuery.from(Livre.class);
	deleteQuery.where(cb.equal(livre.get("id"), id));
	try {
	    et.begin();
	    em.createQuery(deleteQuery).executeUpdate();
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    throw new DAOException("Erreur lors de la supperssion du livre " + id + " : " + e.getMessage());
	}
	
    }
    
    public static Livre findById(int val) {
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Livre> query = cb.createQuery(Livre.class);
	Root<Livre> liste = query.from(Livre.class);
	Predicate clauseWhere = cb.equal(liste.get("id"), val);
	query.select(liste);
	query.where(clauseWhere);
	
	TypedQuery<Livre> tq = em.createQuery(query);
	return tq.getSingleResult();
    }
    
    public static List<Livre> findAll() {
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Livre> query = cb.createQuery(Livre.class);
	Root<Livre> liste = query.from(Livre.class);
	query.select(liste);
	TypedQuery<Livre> tq =em.createQuery(query);
	return tq.getResultList();
    }
    
    public static List<Livre> findAllOrderByTitreAsc(){
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Livre> query = cb.createQuery(Livre.class);
	Root<Livre> livre = query.from(Livre.class);
	Order ordre = cb.asc(livre.get("titre"));
	query.select(livre);
	query.orderBy(ordre);
	TypedQuery<Livre> tq = em.createQuery(query);
	return tq.getResultList();
    }
    
    public static List<Livre> findAllOrderByTitreDesc(){
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Livre> query = cb.createQuery(Livre.class);
	Root<Livre> livre = query.from(Livre.class);
	Order ordre = cb.desc(livre.get("titre"));
	query.select(livre);
	query.orderBy(ordre);
	TypedQuery<Livre> tq = em.createQuery(query);
	return tq.getResultList();
    }
    
    public static List<Livre> findByAuteurLike(String auteur) {
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Livre> query = cb.createQuery(Livre.class);
	Root<Livre> livre = query.from(Livre.class);
	Predicate clauseWhere = cb.like(livre.get("auteur"), "%" + auteur + "%");
	query.select(livre);
	query.where(clauseWhere);
	TypedQuery<Livre> tq = em.createQuery(query);
	return tq.getResultList();
    }
    
    public static int getMaxId() {
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Integer> query = cb.createQuery(Integer.class);
	Root<Livre> livre = query.from(Livre.class);
	query.select(cb.max(livre.get("id")));
	Integer tq = (Integer) em.createQuery(query).getSingleResult();
	return tq;
    }
    
    public static int getMinId() {
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Integer> query = cb.createQuery(Integer.class);
	Root<Livre> livre = query.from(Livre.class);
	query.select(cb.min(livre.get("id")));
	Integer tq = (Integer) em.createQuery(query).getSingleResult();
	return tq;
    }
}
