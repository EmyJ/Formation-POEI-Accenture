package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eni Ecole Le panier stocke les articles sélectionnés par
 *         l'utilisateur au cours de sa navigation. Le panier n'est pas
 *         sauvegardé.
 /* modif calcul panier Aurélien Martineau 
 */
public class Panier {

	// Attributs d'instance
	private List<Ligne> lignesPanier;
	private float montant;

	// Constructeurs
	public Panier() {
		//float montant;
		lignesPanier = new ArrayList<Ligne>();
	}

	// Getters et Setters
	/**
	 * @return the lignesPanier
	 */
	public final List<Ligne> getLignesPanier() {
		return lignesPanier;
	}

	/**
	 * Ajouter une ligne au panier. Le prix de la ligne est calculé (Qte*prix)
	 * 
	 * @param numero
	 * @param article
	 * @param qte
	 * 
	 */
	public void addLigne(Article article, int qte) {

		Ligne ligneAdding = new Ligne(article, qte);
		lignesPanier.add(ligneAdding);
		calculMontant();
	}

	/**
	 * Retourne la ligne sélectionnée du Panier ou null si pas trouvée
	 * 
	 * @param index
	 * @return
	 */
	public final Ligne getLigne(int index) {
		return lignesPanier.get(index);
	}

	
	/**
	 * Supprimer la ligne du panier. La quantité en stock augmente de la
	 * quantité associée à la ligne
	 * 
	 * @param numero
	 */
	public void removeLigne(int index) {
		lignesPanier.remove(index);
		calculMontant();
	}

	/**
	 * Modifier la quantité placée dans le panier La quantité en stock augment
	 * ou diminue en fonction de cette nouvelle qté
	 * 
	 * @param index
	 * @param newQte
	 * @throws PlusEnStockException
	 */
	public void updateLigne(int index, int newQte) {
		this.getLigne(index).setQte(newQte);
		calculMontant();
	}

	public float getMontant() {
		return montant;
	}

	private void calculMontant() {
		this.montant = 0;
		for (Ligne l : lignesPanier)
		{
			this.montant+=l.getPrix();
		}
	}
	
	/**
	 * Pr�senter le d�tail du panier
	 */
	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("Panier : \n\n");
		for (Ligne ligne : lignesPanier) {
			bf.append("ligne " );
			bf.append( lignesPanier.indexOf(ligne) );
			bf.append( " :\t");
			bf.append(ligne.toString());
			bf.append("\n");
		}
		bf.append("Valeur du panier : ");
		bf.append(String.format("%.2f",getMontant()));
		bf.append("\n\n");
		return bf.toString();
	}

}
