package fr.eni.jpa.demo06.main;

import java.util.List;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo06.entity.Adresse;
import fr.eni.jpa.demo06.entity.AdresseDAO;
import fr.eni.jpa.demo06.entity.Personne;
import fr.eni.jpa.demo06.entity.PersonneDAO;

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

	PersonneDAO pDao = new PersonneDAO();
	AdresseDAO aDao = new AdresseDAO();

	// ajout
	try {
	    pDao.add(p1);
	    pDao.add(p2);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	System.out.println("supprimer a1");
	try {
	    aDao.delete(a1);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	// lister
	List<Personne> listeP = pDao.findAll();
	System.out.println("Liste des personnes : ");

	for (Personne personne : listeP) {
	    System.out.println(personne);
	}

	System.out.println("Liste des adresses : ");
	List<Adresse> listeA = aDao.findAll();
	for (Adresse adresse : listeA) {
	    System.out.println(adresse);
	}

	DAOUtil.close();
    }

}
