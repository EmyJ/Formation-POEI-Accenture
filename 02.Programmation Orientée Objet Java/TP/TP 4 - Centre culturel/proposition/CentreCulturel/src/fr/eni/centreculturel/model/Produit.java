/**
 * 
 */
package fr.eni.centreculturel.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bmartin
 *
 */
public abstract class Produit {
	private String titre;
	private Date dateSortie;
	private float prixAchat;
	
	private Auteur auteur;

	/**
	 * @param titre
	 * @param dateSortie
	 * @param prixAchat
	 * @param auteur
	 */
	public Produit(String titre, Date dateSortie, float prixAchat, Auteur auteur) {
		this.titre = titre;
		this.dateSortie = dateSortie;
		this.prixAchat = prixAchat;
		this.auteur = auteur;
	}

	/**
	 * @return the prixAchat
	 */
	protected final float getPrixAchat() {
		return prixAchat;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return String.format(
				"Produit [titre=%s, dateSortie=%s, prixAchat=%5.2f, prixVente=%5.2f, auteur=%s]",
				titre, formatter.format(dateSortie), prixAchat, getPrixVente(), auteur.toString());
	}
	
	public abstract float getPrixVente();
	public abstract float getPrixVente(float reduction);
		
	
	
}
