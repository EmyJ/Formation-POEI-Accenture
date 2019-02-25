/**
 * 
 */
package fr.eni.jpa.methotde1.main;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eni.jpa.methode1.entity.Personne;
import fr.eni.jpa.methode1.entity.PersonnePK;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 10:30:19
 */
public class TestPersonne {

@SuppressWarnings("unchecked")
public static void main(String[] arg) {
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("Mysql_UP");
	EntityManager em = emf.createEntityManager();
	
	Personne p1 = new Personne("Legrand", "Lucie", new GregorianCalendar(2000, 05, 22));
	Personne p2 = new Personne("Legrand", "Jeanne", new GregorianCalendar(1990, 07, 12));
	
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
	
	String requete = "from Personne1 p";
	List<Personne> listeP = em.createQuery(requete).getResultList();
	
	System.out.println("liste des Personnes : ");
	for (Personne personne : listeP) {
	    System.out.println(personne);
	}
	
	PersonnePK pk = new PersonnePK("Legrand", "Jeanne");
	Personne p = em.find(Personne.class, pk);
	System.out.println("Personne recherché : " + p);
	
	em.close();
	emf.close();
    }
}
