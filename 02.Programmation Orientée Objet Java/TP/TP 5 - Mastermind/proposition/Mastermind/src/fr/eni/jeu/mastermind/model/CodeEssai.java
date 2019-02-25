package fr.eni.jeu.mastermind.model;

import java.util.StringTokenizer;

/**
 * Il s'agit du code couleur saisi par l'utilisateur
 * @author bmartin
 *
 */
public class CodeEssai extends Code {

	public boolean cancel=false;
	
	public CodeEssai(String codeSaisi)  {

		int i = 0;
		StringTokenizer lst = new StringTokenizer(codeSaisi," ,;");
		//pions = new Pion[lst.countTokens()];
		pions = new Pion[Code.NBPIONS];
		while (lst.hasMoreTokens()) {
		
			pions[i++] = new Pion(lst.nextToken());
			
		}	
	}
	
	
	public CodeEssai(boolean cancel) {
		this.cancel=cancel;
	}	
	
}