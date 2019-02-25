package fr.eni.jpa.demo14.main;

import java.util.ArrayList;
import java.util.List;

import fr.eni.jpa.demo14.entity.PersonneDAO;
import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo14.entity.Personne;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 16:49:44
 */
public class MainPersonne {

    public static void main(String[] args) {
	List<String> listeSports1 = new ArrayList<>();
	listeSports1.add("Athétisme");
	listeSports1.add("Judo");
	listeSports1.add("Badminton");
	listeSports1.add("Hand-ball");
	
	Personne p1 = new Personne("Legrand", "Lucie", listeSports1);
	
	List<String> listeSports2 = new ArrayList<>();
	listeSports2.add("Football");
	listeSports2.add("Judo");
	listeSports2.add("Badminton");
	listeSports2.add("Hand-ball");
	
	Personne p2 = new Personne("Lepetit", "Marc", listeSports2);
	
	try {
	    PersonneDAO.add(p1);
	    PersonneDAO.add(p2);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	List<Personne> listeP = PersonneDAO.findAll();
	System.out.println("Liste des personne : ");
	for (Personne personne : listeP) {
	    System.out.println(personne);
	}
	
	try {
	    PersonneDAO.delete(p1);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	System.out.println("\nListe des personnes après suppression");
	listeP = PersonneDAO.findAll();
	for (Personne personne : listeP) {
	    System.out.println(personne);
	}
	
	DAOUtil.close();
    }

}
