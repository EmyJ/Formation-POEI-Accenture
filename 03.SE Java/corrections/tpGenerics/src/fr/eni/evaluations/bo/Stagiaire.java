package fr.eni.evaluations.bo;

import java.util.ArrayList;
import java.util.List;

public class Stagiaire {
	
	private int noStagiaire;	
	private String prenom,  nom, email, motDePasse;
	private List<Evaluation> evaluations;
	private Promotion promotion;
	
	//Constructeur vide
	public Stagiaire(){
		super();
	}
	
	//Constructeur avec paramètres
	public Stagiaire(
					 String prenom, 
					 String nom, 
					 String email, 
					 String motDePasse
					 ) 
			{		
		this();
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setEmail(email);
		this.setMotDePasse(motDePasse);
		
		this.evaluations = new ArrayList();

	}

	//Getters et Setters
	public int getNoStagiaire() {
		return noStagiaire;
	}
	
	

	public void setNoStagiaire(int noStagiaire) {
		this.noStagiaire = noStagiaire;
	}

	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Stagiaire [noStagiaire = " + noStagiaire + ", prenom = " + prenom + ", nom = " + nom + ", email = " + email
				+ ", motDePasse = " + motDePasse + "]";
	}




	
	
}
