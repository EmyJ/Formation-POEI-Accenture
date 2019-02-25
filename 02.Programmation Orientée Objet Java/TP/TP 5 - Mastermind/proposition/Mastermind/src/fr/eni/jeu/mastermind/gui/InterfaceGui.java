/**
 * 
 */
package fr.eni.jeu.mastermind.gui;

import fr.eni.jeu.mastermind.model.CodeEssai;
import fr.eni.jeu.mastermind.model.CodeSecret;

/**
 * @author bmartin
 *
 */
public interface InterfaceGui {
	public void afficherErreur(String e);
	public CodeEssai saisirCodeEssai(int numEssai, int nb_pion);
	public void afficherResultatEssai(int nbBienPlace, int nbMalPlace) ;
	public void afficherCodeEssai(CodeEssai code) ;
	public void afficherCodeSecret(CodeSecret code);
}
