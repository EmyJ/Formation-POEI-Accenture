/**
 * 
 */
package fr.eni.jeu.mastermind.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.eni.jeu.mastermind.model.CodeEssai;
import fr.eni.jeu.mastermind.model.CodeSecret;
import fr.eni.jeu.mastermind.model.Pion;

/**
 * @author bmartin
 *
 */
public class Console implements InterfaceGui{

	@Override
	public void afficherErreur(String e) {
		System.out.println(e);
	}

	@Override
	public CodeEssai saisirCodeEssai(int numEssai, int nb_pion) {
		System.out.println("choisissez "+nb_pion+" couleurs parmi "+Pion.NOMS_COULEURS+" (séparées par ,;)");
	 	System.out.print("Essai numéro " + numEssai + " : ");
      	BufferedReader in   = new BufferedReader(new InputStreamReader(System.in));
      	String essai="";
      	try {
        essai=in.readLine();
      	} catch (IOException e)	{
      	}
      	if (essai.length()==0) {
      		return null;
      	}
      	if (essai.equalsIgnoreCase("fin")) {
      		return new CodeEssai(true);
      	}
      	
		return new CodeEssai(essai);
	}

	@Override
	public void afficherResultatEssai(int nbBienPlace, int nbMalPlace) {
		System.out.println("Résultat : [Bien placé(s) :" + nbBienPlace + "|Mal placé(s) :" + nbMalPlace + "]");
	}

	@Override
	public void afficherCodeEssai(CodeEssai code) {
		System.out.print (code + "\t");
	}

	@Override
	public void afficherCodeSecret(CodeSecret code) {
		System.out.println("le code secret : " + code);
	}
	


}
