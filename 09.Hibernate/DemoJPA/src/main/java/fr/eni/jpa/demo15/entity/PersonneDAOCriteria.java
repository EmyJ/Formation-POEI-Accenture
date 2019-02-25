package fr.eni.jpa.demo15.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo15.entity.Personne;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 21 févr. 2019 - 10:22:36
 */
public class PersonneDAOCriteria {

    public static List<Personne> findAll() {
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Personne> query = cb.createQuery(Personne.class);
	Root<Personne> liste = query.from(Personne.class);
	query.select(liste);
	
	TypedQuery<Personne> tq =em.createQuery(query);
	return tq.getResultList();
    }

    public static List<Personne> findAllTriNom() {
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Personne> query = cb.createQuery(Personne.class);
	Root<Personne> pers = query.from(Personne.class);
	Order ordre = cb.asc(pers.get("nom"));
	query.select(pers);
	query.orderBy(ordre);
	
	TypedQuery<Personne> tq = em.createQuery(query);
	return tq.getResultList();
    }
    
    public static List<Personne> findLegrand() {
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Personne> query = cb.createQuery(Personne.class);
	Root<Personne> pers = query.from(Personne.class);
	Predicate clauseWhere = cb.equal(pers.get("nom"), "Legrand");
	query.select(pers);
	query.where(clauseWhere);
	
	TypedQuery<Personne> tq = em.createQuery(query);
	return tq.getResultList();
    }
    
    public static List<Personne> findMesdemoiselles(){
	EntityManager em = DAOUtil.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Personne> query = cb.createQuery(Personne.class);
	Root<Personne> pers = query.from(Personne.class);
	Join<Personne, Civilite> civ = pers.join("civilite");
	Predicate clauseWhere = cb.equal(civ.get("cle"), "Mlle");
	query.select(pers);
	query.where(clauseWhere);
	
	TypedQuery<Personne> tq = em.createQuery(query);
	return tq.getResultList();
    }
}
