package fr.eni.jpa.demo15.main;

import java.util.List;

import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.demo15.entity.Civilite;
import fr.eni.jpa.demo15.entity.CiviliteDAO;
import fr.eni.jpa.demo15.entity.Personne;
import fr.eni.jpa.demo15.entity.PersonneDAO;
import fr.eni.jpa.demo15.entity.PersonneDAOQuery;
import fr.eni.jpa.exception.DAOException;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 21 févr. 2019 - 10:50:38
 */
public class MainPersonneDynamicqueries {

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
	
	Civilite m = CiviliteDAO.findById("M");
	Civilite mlle = CiviliteDAO.findById("Mlle");
	Civilite mme = CiviliteDAO.findById("Mme");
	
	Personne p1 = new Personne("N10", "P1", m);
	Personne p2 = new Personne("N20", "P2", mlle);
	Personne p3 = new Personne("N30", "P3", mme);
	Personne p4 = new Personne("N40", "P4", mme);
	Personne p5 = new Personne("N50", "P5", mlle);
	Personne p6 = new Personne("N60", "P6", m);
	Personne p7 = new Personne("N70", "P7", mme);
	Personne p8 = new Personne("Legrand", "Aline", mme);
	Personne p9 = new Personne("Lepetit", "Lucie", mlle);
   
    
    try {
	    PersonneDAO.add(p1);
	    PersonneDAO.add(p2);
	    PersonneDAO.add(p3);
	    PersonneDAO.add(p4);
	    PersonneDAO.add(p5);
	    PersonneDAO.add(p6);
	    PersonneDAO.add(p7);
	    PersonneDAO.add(p8);
	    PersonneDAO.add(p9);
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	
	System.out.println("\nTous les Legrand");
	List<Personne> listeP = PersonneDAOQuery.findLegrand();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	System.out.println("\nTous les Lepetit");
	listeP = PersonneDAOQuery.findLepetit();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	System.out.println("\nTous les Lepetit");
	listeP = PersonneDAOQuery.findByNom("Lepetit");
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	System.out.println("\nTous les Legrand");
	listeP = PersonneDAOQuery.findByNom2("Legrand");
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	try {
	    System.out.println("\nLe 120 : " + PersonneDAOQuery.findByIdQuery(120));
	} catch (Exception e) {
	    System.out.println("\nPas de 120");
	}
	
	System.out.println("\nNombre de personne : " + PersonneDAOQuery.nombreDElements());
	
	System.out.println("\nTous les premon");
	List<String> listeS = PersonneDAOQuery.tousLesPrenom();
	for (String s : listeS) {
	    System.out.println(s);
	}
	
	System.out.println("\nSuppression des legrand");
	try {
	    PersonneDAOQuery.suppresionLeGrand();
	} catch (Exception e) {
	   e.printStackTrace();
	}
	
	System.out.println("\nModification du 3");
	try {
	    PersonneDAOQuery.modifier(3, "Marc");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	listeP = PersonneDAOQuery.findAll();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	System.out.println("\nTri par civilite");
	listeP = PersonneDAOQuery.jointureAvecTri();
	for (Personne p : listeP) {
	    System.out.println(p);
	}
	
	DAOUtil.close();
    }
}
