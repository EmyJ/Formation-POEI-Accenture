package fr.eni.evaluations.bo;

import java.util.ArrayList;
import java.util.List;

public class Promotion {

	private int noPromo;
	private String nomPromo;
	private List<Stagiaire> satigiaires;
	private Stagiaire stagiaire;
	
	public Promotion(int noPromo, String nomPromo) {
		super();
		this.noPromo = noPromo;
		this.nomPromo = nomPromo;
		this.satigiaires = new ArrayList();
	}
	
	public int getNoPromo() {
		return noPromo;
	}
	public void setNoPromo(int noPromo) {
		this.noPromo = noPromo;
	}
	public String getNomPromo() {
		return nomPromo;
	}
	public void setNomPromo(String nomPromo) {
		this.nomPromo = nomPromo;
	}
	
	public List<Stagiaire> getSatigiaires() {
		return satigiaires;
	}
	public void setSatigiaires(List<Stagiaire> satigiaires) {
		this.satigiaires = satigiaires;
	}
	
	@Override
	public String toString() {
		return "Promotion [noPromo = " + noPromo + ", nomPromo = " + nomPromo + "]";
	}
}
