package fr.eni.jpa.demo07.main;

import java.util.ArrayList;
import java.util.List;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo07.entity.Adresse;
import fr.eni.jpa.demo07.entity.Personne;
import fr.eni.jpa.demo07.entity.PersonneDAO;
import fr.eni.jpa.exception.DAOException;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:16:43
 */
public class TestPersonne {

    public static void main(String[] args) {
	Adresse a1 = new Adresse("44000", "Nantes");
	Adresse a2 = new Adresse("56000", "Vannes");
	Adresse a3 = new Adresse("29200", "Brest");
	Adresse a4 = new Adresse("29000", "Quimper");
	
	List<Adresse> liste1 = new ArrayList<>();
	List<Adresse> liste2 = new ArrayList<>();
	
	liste1.add(a1); liste1.add(a2);
	liste2.add(a3); liste2.add(a4);
	
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
	//Tentative de modification
	a1.setCodePostal("44100");
	//p1.getListeAdresses().get(0).setCodePostal("44100");
	
	Adresse a5 = new Adresse("75000", "Rennes");
	p1.getListeAdresses().add(a5);
	try {
	    PersonneDAO.update(p1);
	} catch (DAOException e) {
	    e.printStackTrace();
	}

	System.out.println("\nListe des personnes en base après modif de a1 : ");
	listeP = PersonneDAO.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	//Tentative de suppression
	p1.getListeAdresses().remove(a2);
	try {
	    PersonneDAO.update(p1);
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	System.out.println("\nListe des personnes en base après supp de a2 : ");
	listeP = PersonneDAO.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	//Tentative de remplacement de la liste des adresse de p2
	Adresse a6 = new Adresse("59000", "Lille");
	Adresse a7 = new Adresse("69000", "Lyon");
	
	List<Adresse> liste3 = new ArrayList<>();
	liste3.add(a6); liste3.add(a7);
	
	p2.setListeAdresses(liste3);
	try {
	    PersonneDAO.update(p2);
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	System.out.println("\nListe des personnes en base après remplacement: ");
	listeP = PersonneDAO.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	//supperssion des 2 personnes
	try {
	    PersonneDAO.delete(p1);
	    PersonneDAO.delete(p2);;
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	System.out.println("\nListe des personnes en base après suppression: ");
	listeP = PersonneDAO.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	DAOUtil.close();
    }

}
