/**
 * 
 */
package fr.eni.centreculturel.model;

import java.util.Arrays;
import java.util.Date;

/**
 * @author bmartin
 *
 */
public class Cd extends Produit {

	private Piste[] pistes;
	private int indexPiste = 0;
	/**
	 * @param titre
	 * @param dateSortie
	 * @param prixAchat
	 * @param auteur
	 */
	public Cd(String titre, Date dateSortie, float prixAchat, Auteur auteur) {
		super(titre, dateSortie, prixAchat, auteur);
	}
	
	public void addPiste(int numero, String intitule, Date duree) throws ArrayIndexOutOfBoundsException {
		//à l'ajout de la première piste...
		if (pistes == null) pistes = new Piste[15];
		Piste piste = new Piste(numero, intitule, duree);
		pistes[indexPiste] = piste;
		indexPiste++;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 15;
		return String.format(
				"%s\n\tCd [pistes=%s]", super.toString(),
				pistes != null ? Arrays.asList(pistes).subList(0,
						Math.min(pistes.length, maxLen)) : null);
	}

	/* (non-Javadoc)
	 * @see fr.eni.centreculturel.model.Produit#getPrixVente()
	 */
	@Override
	public float getPrixVente() {
		return super.getPrixAchat() * 1.20f;
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
