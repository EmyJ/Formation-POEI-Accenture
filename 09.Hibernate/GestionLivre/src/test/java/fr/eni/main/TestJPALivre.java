package fr.eni.main;

import java.util.List;

import fr.eni.bean.Livre;
import fr.eni.dao.DAOUtil;
import fr.eni.dao.LivreDAO;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version GestionLivre - V1.0
 * @date 21 févr. 2019 - 14:14:33
 */
public class TestJPALivre {

    public static void main(String[] args) {
	
	Livre l1 = new Livre("Emile Zola", "La bête humaine", 450);
	Livre l2 = new Livre("JP Sarte", "Huis clos", 350);
	Livre l3 = new Livre("Albert Camus", "L'étrange", 476);
	Livre l4 = new Livre("Albert Camus", "La peste", 276);
	
	try {
	    LivreDAO.add(l1);
	    LivreDAO.add(l2);
	    LivreDAO.add(l3);
	    LivreDAO.add(l4);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	System.out.println("\nCréation de 4 livres :");
	List<Livre> liste = LivreDAO.findAll();
	for (Livre livre : liste) {
	    System.out.println(livre);
	}
	
	System.out.println("\nListe des livres triés par titre ascendant :");
	liste = LivreDAO.findAllOrderByTitreAsc();
	for (Livre livre : liste) {
	    System.out.println(livre);
	}
	
	System.out.println("\nListe des livres triés par titre descendant :");
	liste = LivreDAO.findAllOrderByTitreDesc();
	for (Livre livre : liste) {
	    System.out.println(livre);
	}
	
	System.out.println("\nListe des livres de Camus");
	liste = LivreDAO.findByAuteurLike("Camus");
	for (Livre livre : liste) {
	    System.out.println(livre);
	}
	
	System.out.println("\nPermier id : " + LivreDAO.getMinId());
	
	System.out.println("\nDernier id : " + LivreDAO.getMaxId());
	
	System.out.println("\nLivre id = 2 : " + LivreDAO.findById(2));
	
	try {
	    System.out.println("\nLivre id = 22 : " + LivreDAO.findById(22));
	} catch (Exception e) {
	    System.out.println("\nLivre id = 22 : null");
	}
	
	System.out.println("\nListe des livres apres suppression et modification :");
	//update
	l2.setAuteur("Jean Paul Sarte");
	l2.setNbPages(354);
	try {
	    LivreDAO.update(l2);
	} catch (Exception e) {
	   e.printStackTrace();
	   e.getMessage();
	}
	
	//delete
	try {
	    LivreDAO.delete(1);
	    LivreDAO.delete(3);
	} catch (Exception e) {
	   e.printStackTrace();
	}
	
	liste = LivreDAO.findAll();
	for (Livre livre : liste) {
	    System.out.println(livre);
	}
	DAOUtil.close();
    }

}
