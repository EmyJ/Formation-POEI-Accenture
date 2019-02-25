package fr.eni.jpa.methode2.entity;

import java.io.Serializable;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 11:33:13
 */
public class PersonnePK implements Serializable{

    private static final long serialVersionUID = 1L;
	
	private String nom;
	private String prenom;
	
	public PersonnePK() {}
	
	public PersonnePK(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    return nom + " " + prenom;
	}
	
	
}
