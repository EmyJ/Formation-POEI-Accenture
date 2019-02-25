package exercice2;

import java.awt.Color;

public class Voiture {
	
	private int num_serie;
	private String immatriculation;
	private String marque;
	private Color couleur;
	private int annee;
	private Individu proprietaire;
	
	public Voiture(int num_serie, String immatriculation, String marque, Color couleur, int annee) {
		this.num_serie = num_serie;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.couleur = couleur;
		this.annee = annee;
	}

	public void demarrer() {
		
	}
	
	public void klaxonner() {
		
	}
	
	public void conduire() {
		
	}
	
	public void arreter() {
		
	}

	public int getNum_serie() {
		return num_serie;
	}



	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMarque() {
		return marque;
	}


	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getAnnee() {
		return annee;
	}


	public Individu getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Individu proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "Voiture [num_serie=" + num_serie + ", immatriculation=" + immatriculation + ", marque=" + marque
				+ ", couleur=" + Couleur.donneCouleur(couleur.getRed(), couleur.getGreen(), couleur.getBlue()) + ", annee=" + annee + ", proprietaire=" + proprietaire + "]";
	}

}
