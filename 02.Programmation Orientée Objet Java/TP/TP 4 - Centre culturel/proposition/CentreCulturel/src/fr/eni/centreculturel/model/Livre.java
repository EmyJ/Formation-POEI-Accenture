/**
 * 
 */
package fr.eni.centreculturel.model;

import java.util.Date;

/**
 * @author bmartin
 *
 */
public class Livre extends Produit {

	private Editeur editeur;

	/**
	 * @param titre
	 * @param dateSortie
	 * @param prixAchat
	 * @param auteur
	 * @param editeur
	 */
	public Livre(String titre, Date dateSortie, float prixAchat, Auteur auteur,
			Editeur editeur) {
		super(titre, dateSortie, prixAchat, auteur);
		this.editeur = editeur;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s\n\tLivre [editeur=%s]", super.toString(), editeur.toString());
	}

	/* (non-Javadoc)
	 * @see fr.eni.centreculturel.model.Produit#getPrixVente()
	 */
	@Override
	public float getPrixVente() {
		return super.getPrixAchat() * 1.25f;
	}

	/* (non-Javadoc)
	 * @see fr.eni.centreculturel.model.Produit#getPrixVente(float)
	 */
	@Override
	public float getPrixVente(float pourcentagereduction) {
		float prixVente = super.getPrixAchat() * 1.25f;
		return prixVente - (prixVente * (pourcentagereduction/100));
	}
}
