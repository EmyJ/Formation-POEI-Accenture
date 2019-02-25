/**
 * 
 */
package fr.eni.centreculturel.test;

import java.util.GregorianCalendar;
import java.util.Scanner;

import fr.eni.centreculturel.model.Auteur;
import fr.eni.centreculturel.model.Catalogue;
import fr.eni.centreculturel.model.Cd;
import fr.eni.centreculturel.model.Editeur;
import fr.eni.centreculturel.model.Livre;
import fr.eni.centreculturel.model.Produit;

/**
 * @author bmartin
 *
 */
public class ModuleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//A vous de constituer votre module de test afin d'obtenir le résultats attendus
		
		//creation de 2,3 auteurs
		Auteur BrunoMars = new Auteur("Mars", "Bruno", null, "www.brunomars.com/fr");
		Auteur Slash = new Auteur("Slash", "Slash", "https://twitter.com/slash");
		Auteur Legardinier = new Auteur("Legardinier", "Gilles",null,null);
		System.out.println("** Les auteurs");
		System.out.println("**************");
		System.out.println(BrunoMars.toString());
		System.out.println(Slash.toString());
		System.out.println(Legardinier.toString());
		
		//creation de 2,3 editeurs
		System.out.println("** Les editeurs");
		System.out.println("***************");
		Editeur Pocket = new Editeur("Pocket","12 avenue d'Italie – 75013 Paris","www.pocket.fr");
		System.out.println(Pocket.toString());
		
		//creation de 2,3 livres
		System.out.println("** Les livres");
		System.out.println("*************");
		Livre CompletementCrame = new Livre("Completement cramé",new GregorianCalendar(2014,2,13).getTime(), 7.60f, Legardinier, Pocket);
		Livre DemainJarrete = new Livre("Demain j'arrête !",new GregorianCalendar(2011,10,10).getTime(), 6.52f, Legardinier, Pocket);
		System.out.println(CompletementCrame.toString());
		System.out.println(DemainJarrete.toString());
		
		//creation de 2,3 cd
		System.out.println("** Les cd");
		System.out.println("*********");
		Cd Unorthodox = new Cd("Unorthodox Jukebox", new GregorianCalendar(2012,11,5).getTime(), 10.30f, BrunoMars);
		Cd SlashBySlash = new Cd("Slash by Slash", new GregorianCalendar(2010,3,5).getTime(), 11.52f, Slash);
		System.out.println(Unorthodox.toString());
		System.out.println(SlashBySlash.toString());
		
		//ajouter les produits au catalogue
		Catalogue catalogue = new Catalogue();
		catalogue.add(CompletementCrame);
		catalogue.add(DemainJarrete);
		catalogue.add(Unorthodox);
		catalogue.add(SlashBySlash);
		
		//tester le polymorphisme (en affichant un livre issu du catalogue avec son prix de vente)
		System.out.println("** polymorphisme");
		System.out.println("****************");
		Produit p = catalogue.get(1);
		System.out.println(p.toString());
		
		//ajouter une piste à un cd issu du catalogue
		p = catalogue.get(2);
		if (p instanceof Cd)
			((Cd)p).addPiste(1, "Gorilla", new GregorianCalendar(0,0,0,0,4,4).getTime());
		System.out.println(p.toString());
		
		//lister l'intégralité du catalogue
		System.out.println("** Le catalogue complet");
		System.out.println("***********************");
		Produit[] extrait = catalogue.extract();
		for (Produit produit : extrait) {
			if (produit == null) break;
			System.out.println(produit.toString());
		}
		
		//extraire les produits par type du catalogue
		System.out.println("** Les livres au catalogue");
		System.out.println("**************************");
		Produit[] livres = catalogue.extract(CompletementCrame);
		for (Produit produit : livres) {
			if (produit == null) break;
			System.out.println(produit.toString());
		}
		
		//extraire les produits par type du catalogue
		System.out.println("** Les cds au catalogue");
		System.out.println("***********************");
		Produit[] cds = catalogue.extract(Cd.class);
		for (Produit produit : cds) {
			if (produit == null) break;
			System.out.println(produit.toString());
		}
		
		//extraire les produits par type du catalogue
		System.out.println("** Les livres au catalogue");
		System.out.println("**************************");
		livres = catalogue.extract(Livre.class);
		for (Produit produit : livres) {
			if (produit == null) break;
			System.out.println(produit.toString());
		}
		
		System.out.println("Appuyez sur entrée pour sortir du test...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
	}

}
