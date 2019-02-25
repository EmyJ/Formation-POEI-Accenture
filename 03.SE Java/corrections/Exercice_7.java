import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exercice_7 {

	public static Scanner scan = new Scanner(System.in);
	public static final int MAX = 20;

	public static void main(String[] args) {
		// Écrire un programme java dans éclipse qui permet de faire la saisie de notes
		// dans un tableau puis
		// de retourner la moyenne des valeurs saisies.

		// Demande le nb de notes
		System.out.println("Combien de notes avez-vous eues cette année ?");
		int nbNotes = scan.nextInt();
		scan.nextLine();

		while (nbNotes <= 0) {
			System.out.println("Veuillez entrer un nombre supérier à 0");
			nbNotes = scan.nextInt();
			scan.nextLine();
		}

		// Définir le tableau de notes
		float[] notes = new float[nbNotes];

		int j = 0;
		float totalNotes = 0;

		do {
			System.out.println("Quelle note avez-vous eu entre 0 et " + MAX + " ?");
			float note = scan.nextFloat();
			scan.nextLine();
			while (note < 0 || note > MAX) {
				System.out.println("Veuillez entrer une note comprise entre 0 et " + MAX);
				note = scan.nextFloat();
				scan.nextLine();
			}
			notes[j] = note;
			totalNotes += notes[j];
			j++;
		} while (j < nbNotes);

		float moyenne = totalNotes / nbNotes;

		String moyenneToString = String.format("Votre moyenne est de %5.2f/%d", moyenne, MAX);
		System.out.println(moyenneToString);

		System.out.println("Souhaitez-vous enregistrer votre résultat ? Entrez 1 pour OUI ou 0 pour NON");

		int choix = scan.nextInt();
		scan.nextLine();

		while (choix != 0 && choix != 1) {
			System.out.println("Entrer 0 ou 1");
			choix = scan.nextInt();
			scan.nextLine();
		}

		if (choix == 1) {
			enregistre(moyenneToString);
		}

		System.out.println("merci, à la prochaine fois !");

		scan.close();

	}

	/**
	 * Enregistre la note dans un fichier
	 * 
	 * @param moyenneToString
	 */
	public static void enregistre(String moyenneToString) {
		Date aujourdhui = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("d_MM_yyyy_h_m");
		String fichier = String.format("resultat_%s.txt", sdf.format(aujourdhui));

		try {
//			File ff = new File("C:\\Users\\fbourell2018\\Documents\\Java_Project\\Bonne_Annee_2019\\" + fichier);
//			ff.createNewFile();
//			FileWriter ffw = new FileWriter(ff);
			FileWriter ffw = new FileWriter(fichier);
			ffw.write(moyenneToString);
			ffw.close();
			System.out.print("c'est fait, ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
