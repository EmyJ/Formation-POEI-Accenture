package fr.eni.skillsContextes;

import java.io.Serializable;

public class Valeur implements Serializable{
    
    	private static final long serialVersionUID = 4509031499840556944L;
	
    	private String valeur;

	
	public Valeur() {
	}
	
	public Valeur(String valeur) {
		super();
		this.valeur = valeur;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

}
