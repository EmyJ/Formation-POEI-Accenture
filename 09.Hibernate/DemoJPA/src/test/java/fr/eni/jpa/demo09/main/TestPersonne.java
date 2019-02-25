package fr.eni.jpa.demo09.main;

import java.util.List;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo09.entity.Personne;
import fr.eni.jpa.demo09.entity.PersonneDAO;
import fr.eni.jpa.demo09.entity.Civilite;
import fr.eni.jpa.demo09.entity.CiviliteDAO;
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
	Civilite c1 = new Civilite("M", "Monsieur");
	Civilite c2 = new Civilite("Mlle", "Mademoiselle");
	Civilite c3 = new Civilite("Mme", "Madame");

	try {
	    CiviliteDAO.add(c1);
	    CiviliteDAO.add(c2);
	    CiviliteDAO.add(c3);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	try {
	    PersonneDAO.deleteAll();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	Civilite mlle = CiviliteDAO.findById("Mlle");
	Civilite mme = CiviliteDAO.findById("Mme");
	Civilite m = CiviliteDAO.findById("M");

	System.out.println(mlle);
	System.out.println(mme);
	System.out.println(m);

	Personne p1 = new Personne("N1", "P1", m);
	Personne p2 = new Personne("N2", "P2", mlle);
	Personne p3 = new Personne("N3", "P3", mme);
	Personne p4 = new Personne("N4", "P4", mme);
	Personne p5 = new Personne("N5", "P5", mlle);
	Personne p6 = new Personne("N6", "P6", m);
	Personne p7 = new Personne("N7", "P7", mme);

	try {
	    PersonneDAO.add(p1);
	    PersonneDAO.add(p2);
	    PersonneDAO.add(p3);
	    PersonneDAO.add(p4);
	    PersonneDAO.add(p5);
	    PersonneDAO.add(p6);
	    PersonneDAO.add(p7);
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	System.out.println("\nListe des personnes en base : ");
	List<Personne> listeP = PersonneDAO.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}

	try {
	    PersonneDAO.delete(p2);
	    PersonneDAO.delete(p5);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	System.out.println("\nliste des personnes en base apres supp :");
	listeP = PersonneDAO.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}

	System.out.println("\nListe des civilite en base apres supp : ");
	List<Civilite> listeC = CiviliteDAO.findAll();
	for (Civilite c : listeC) {
	    System.out.println(c);
	}

	DAOUtil.close();
    }

}
