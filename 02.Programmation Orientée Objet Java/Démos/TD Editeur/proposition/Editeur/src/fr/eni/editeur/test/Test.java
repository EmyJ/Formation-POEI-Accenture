/**
 * 
 */
package fr.eni.editeur.test;

import java.util.Scanner;

import fr.eni.editeur.model.Client;
import fr.eni.editeur.model.Commande;
import fr.eni.editeur.model.Livre;

/**
 * @author bmartin
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        /*
         * Tester les règles de notre modèle
         */
        //c'est le seul moyen de créer un Livre (isbn : ###-#-####-####-#)
        Livre csharp=null;
		try {
			csharp = new Livre(
			    "Tgroussard",
			    "les fondamentaux du langage",
			    377,
			    "123-4-5678-9101-2"
			    );
			//voici son état
	        System.out.println(csharp.GetLivreToString());
		} catch (Exception e) {
			AfficherErreur(e.getMessage());
		}

        

        //on peut le modifier, à condition de respecter les règles de gestion
        try {
            csharp.setIsbn("123-4-5678-9101-3");
            System.out.println(csharp.GetLivreToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }

        try {
            csharp.setIsbn("123-4-5678-aaaa-4");
            System.out.println(csharp.GetLivreToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }

        try {
            csharp.setIsbn("123-4-5678");
            System.out.println(csharp.GetLivreToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }

        //csharp = null;

        //reproduire les tests pour le modèle Client 
        Client c = null;
        try {
            c = new Client("dupond", "jean-paul de l'horme", "13 rue machin", "01263", "ville");
            System.out.println(c.GetClientToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }

        if (c != null) {
            try {
                c.setNom(null);
                System.out.println(c.GetClientToString());
            } catch (Exception e) {
                AfficherErreur(e.getMessage());
            }

            try {
                c.setCodePostal("00999");
                System.out.println(c.GetClientToString());
            } catch (Exception e) {
                AfficherErreur(e.getMessage());
            }
        }

        //c = null;

        //Tester la commande
        try {
            Commande cde = new Commande(c, csharp);
            System.out.println(cde.GetCommandeToString());
            Livre java = new Livre("Tgroussard",
            "les fondamentaux du langage java",
            412,
            "123-4-5678-9999-2"
            );
            cde.Add(java);
            System.out.println(cde.GetCommandeToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }
        
		System.out.println("Appuyez sur entrée pour sortir du test...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
    }

    private static void AfficherErreur(String message) {
        System.out.println(message);
    }

}
