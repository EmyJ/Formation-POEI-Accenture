package fr.eni.jpa.methotde2.main;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eni.jpa.methode2.entity.PersonnePK;
import fr.eni.jpa.methode2.entity.Personne;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 11:36:38
 */
public class TestPersonne {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("Mysql_UP");
	EntityManager em = emf.createEntityManager();
	
	PersonnePK pk1 = new PersonnePK("Legrand", "Lucie");
	PersonnePK pk2 = new PersonnePK("Legrand", "Jeanne");
	Personne p1 = new Personne(pk1, new GregorianCalendar(2000, 05, 22));
	Personne p2 = new Personne(pk2, new GregorianCalendar(1990, 07, 12));
	
	System.out.println(p1);
	System.out.println(p2);
	em.getTransaction().begin();
	try {
	    em.persist(p1);
	    em.persist(p2);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    em.getTransaction().rollback();
	}
	
	String requete = "from Personne2 p";
	List<Personne> listeP = em.createQuery(requete).getResultList();
	
	System.out.println("liste des Personnes : ");
	for (Personne personne : listeP) {
	    System.out.println(personne);
	}
	
	Personne p = em.find(Personne.class, pk2);
	System.out.println("Personne recherché : " + p);
	
	em.close();
	emf.close();

    }

}
