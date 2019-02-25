
public class HappyNewYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bonne année 2019 !");
		
		/*
		 * Exercice 1:Écrire un algorithme qui déclare et remplisse un tableau de 8 valeurs numériques en les
mettant toutes à zéro.
		 */
		int[] tableau = new int[8];
		for(int i=0; i<tableau.length; i++) {
			tableau[i] =0;
			System.out.println(tableau[i]);
		}
		
		/*
		 * Écrire un algorithme qui déclare et remplisse un tableau contenant les noms des héros du
dessin animé l'age de glace : Scrat, Sid, Manny et Diego
		 */
		/*
		Nom[] nom = Nom.values();
		for(int i=0; i<nom.length; i++) {
			System.out.println(nom[i].name());
		}
		*/
		//une autre facon
		String[] tableau1 =  {"Scrat", "Sid", "Manny" , "Diego"};
		/*
		for(int i =0; i<tableau1.length;i++) {
			System.out.println(tableau[i]);
		}
		*/
		//avec foreach
		for(String i:tableau1) {
			System.out.println(i);
		}
		
		
		/*
		 * TABLEAU MULTIDIMENSION
		 * Écrire un algorithme qui déclare et remplisse un tableau contenant les noms et prénoms de
certains acteurs de starwars : Mark Hamill, Carrie Fisher, Harrison Ford, Alec Guinness.
		 */
		
		String[][] nomActeur = new String [][]{{"Mark","Carrie","Harrison","Alec"},{"Hamill","Fisher","Ford","Guinness"}};
		for(int j =0; j<4; j++) {
			for(int i=0;i<2;i++) {
				 System.out.print(nomActeur[i][j]+ " ");
			}
		}
	}

}
