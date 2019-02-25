package fr.eni.jpa.demo10.main;

import fr.eni.jpa.demo10.entity.PersonneDAO;

import java.util.List;

import fr.eni.jpa.demo10.entity.Pays;
import fr.eni.jpa.demo10.entity.PaysDAO;
import fr.eni.jpa.demo10.entity.Personne;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 13:48:43
 */
public class MainPersonne {

    public static void main(String[] args) {
	Pays fr = getPays("fr", "France");
	Pays it = getPays("it", "Italie");
	Pays gb = getPays("gb", "Grande Bretagne");
	Pays gr = getPays("gr", "Grece");
	Pays es = getPays("es", "Espagne");

	Personne p1 = new Personne("Leblond", "Jean");
	Personne p2 = new Personne("Lechatain", "Lucie");

	// Ajout des pays visités
	p1.addPaysVisites(fr);
	p1.addPaysVisites(it);
	p1.addPaysVisites(es);
	
	p2.addPaysVisites(fr);
	p2.addPaysVisites(gb);
	p2.addPaysVisites(gr);
	
	try {
	    PersonneDAO.add(p1);
	    PersonneDAO.add(p2);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	System.out.println("\nListe des personne en base");
	List<Personne> listeP = PersonneDAO.findAll();
	for (Personne personne : listeP) {
	    System.out.println(personne);
	}
	
	p2.removePaysVisite(gb);
	Pays po = getPays("po", "Portugal");
	p2.addPaysVisites(po);
	
	try {
	    PersonneDAO.update(p2);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	System.out.println("\nListe des personnes en base apres ajout Po");
	listeP = PersonneDAO.findAll();
	for (Personne personne : listeP) {
	    System.out.println(personne);
	}

    }

    private static Pays getPays(String cle, String libelle) {
	Pays p = PaysDAO.findById(cle);
	if (p == null) {
	    p = new Pays(cle, libelle);
	    try {
		PaysDAO.add(p);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return p;
    }
}
