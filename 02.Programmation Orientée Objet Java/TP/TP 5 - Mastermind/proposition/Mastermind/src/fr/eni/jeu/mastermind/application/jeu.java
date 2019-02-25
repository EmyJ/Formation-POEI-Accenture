package fr.eni.jeu.mastermind.application;

import fr.eni.jeu.mastermind.gui.Console;
import fr.eni.jeu.mastermind.gui.InterfaceGui;
import fr.eni.jeu.mastermind.logical.Partie;

public class jeu {

    /**Nombre d'essai maxiautorisé*/
    private static final int NB_ESSAI_MAX=5;

    /**Méthode de lancement de l'application.*/
    public static void main(String[] args) {
		
		
		Partie laPartie;
		InterfaceGui ihm = new Console();	
		laPartie=new Partie(NB_ESSAI_MAX,ihm);
		laPartie.jouer();

    }
}
