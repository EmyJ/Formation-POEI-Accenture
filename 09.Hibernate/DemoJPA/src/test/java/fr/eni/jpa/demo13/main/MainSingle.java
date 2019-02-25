package fr.eni.jpa.demo13.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo13.entity.single.Berline;
import fr.eni.jpa.demo13.entity.single.Voiture;
import fr.eni.jpa.demo13.entity.single.VoitureDeCourse;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 15:18:07
 */
public class MainSingle {
   
    public static void main(String[] args) {
	Voiture v1 = new Voiture("Renault clio");
	Berline b1 = new Berline("BMW", "Rouge");
	VoitureDeCourse c1 = new VoitureDeCourse("Ferrari", "Scuderia Ferrari");
	
	EntityManager em = DAOUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	try {
	    et.begin();
	    em.persist(v1);
	    em.persist(b1);
	    em.persist(c1);
	    et.commit();
	} catch (Exception e) {
	    et.rollback();
	    e.printStackTrace();
	}
	
	List<Voiture> liste = null;
	
	System.out.println("\nListe des voiture de courses");
	liste = em.createQuery("SELECT Object(vc) FROM JoinedVoitureDeCourseEntity vc ", Voiture.class).getResultList();
	for (Voiture voiture : liste) {
	    System.out.println(voiture);
	}
	
	System.out.println("\nListe des Berlines");
	liste = em.createQuery("SELECT Object(b) FROM JoinedBerlineEntity b ", Voiture.class).getResultList();
	for (Voiture voiture : liste) {
	    System.out.println(voiture);
	}
	
	System.out.println("\nListe des voitures (toutes)");
	liste = em.createQuery("SELECT Object(v) FROM JoinedVoitureEntity v ORDER BY id", Voiture.class).getResultList();
	for (Voiture voiture : liste) {
	    System.out.println(voiture);
	}
	
	DAOUtil.close();
    }
}
