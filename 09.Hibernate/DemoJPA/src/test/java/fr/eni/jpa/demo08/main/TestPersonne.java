package fr.eni.jpa.demo08.main;

import java.util.ArrayList;
import java.util.List;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo08.entity.Adresse;
import fr.eni.jpa.demo08.entity.AdresseDAO;
import fr.eni.jpa.demo08.entity.Personne;
import fr.eni.jpa.demo08.entity.PersonneDAO;
import fr.eni.jpa.exception.DAOException;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:16:43
 */
public class TestPersonne {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
	Adresse a1 = new Adresse("44000", "Nantes");
	Adresse a2 = new Adresse("56000", "Vannes");
	Adresse a3 = new Adresse("29200", "Brest");
	Adresse a4 = new Adresse("29000", "Quimper");
	
	List<Adresse> liste1 = new ArrayList<>();
	List<Adresse> liste2 = new ArrayList<>();
	
	liste1.add(a1); 
	liste1.add(a2);
	liste2.add(a3);
	liste2.add(a4);
	
	Personne p1 = new Personne("Lebrun", "Jeanne", liste1);
	Personne p2 = new Personne("Leblond", "Annie", liste2);

	// ajout
	try {
	    PersonneDAO.add(p1);
	    PersonneDAO.add(p2);
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	System.out.println("\nListe des personnes en base ");
	List<Personne> listeP = PersonneDAO.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	Adresse a24 = new Adresse("31000", "Toulouse");
	List<Adresse> listeA = new ArrayList<>();
	listeA.add(a24);
	Personne p24 = new Personne("Lechauve", "Marie", listeA);
	
	//Tentative de sauvegarde de l'adresse
	try {
	    AdresseDAO.add(a24);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	System.out.println("\nliste des personnes en base apres ajout adresse :");
	listeP = PersonneDAO.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	System.out.println("\nSuppression de p1 : ");
	try {
	    PersonneDAO.delete(p1);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	listeP = PersonneDAO.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	DAOUtil.close();
    }

}
