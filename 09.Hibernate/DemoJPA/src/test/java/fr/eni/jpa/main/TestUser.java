/**
 * 
 */
package fr.eni.jpa.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eni.jpa.entity.User;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 18 févr. 2019 - 16:15:04
 */
public class TestUser {

    @SuppressWarnings("unchecked")
    public static void main(String[] arg) {
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("Mysql_UP");
	EntityManager em = emf.createEntityManager();
	
	User u1 = new User("truc", "12345");
	
	em.getTransaction().begin();
	try {
	    em.persist(u1);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    em.getTransaction().rollback();
	}
	
	String requete = "from User u";
	List<User> listeU = em.createQuery(requete).getResultList();
	
	System.out.println("liste des User : ");
	for (User user : listeU) {
	    System.out.println(user);
	}
	em.close();
	emf.close();
    }
}
