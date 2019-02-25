package fr.eni.jpa.demo05.main;

import java.util.List;

import fr.eni.jpa.demo05.entity.PersonneDAO;
import fr.eni.jpa.demo05.entity.Adresse;
import fr.eni.jpa.demo05.entity.Personne;

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
	Adresse a2 = new Adresse("33000", "Bordeaux");
	Personne p1 = new Personne("Lebrun", "Jeanne", a1);
	Personne p2 = new Personne("Leblond", "Annie", a2);

	PersonneDAO dao = new PersonneDAO();
	
	//ajout
	try {
	    dao.add(p1);
	    dao.add(p2);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	//modifier
	p1.getAdresse().setCodePostal("44100");
	try {
	    dao.update(p1);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	//lister
	List<Personne> listP = dao.findAll();
	System.out.println("Liste des personnes (nom) : ");

	for (Personne personne : listP) {
	    System.out.println(personne.getNom());
	}
	System.out.println("Liste des personnes (adresse) : ");

	for (Personne personne : listP) {
	    System.out.println(personne.getAdresse());
	}

	//delete
	System.out.println("suppression de p1 : ");
	try {
	    dao.delete(p1);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
