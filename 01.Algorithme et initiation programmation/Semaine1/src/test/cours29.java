//TP

package test;

public class cours29 {

	public static void main(String[] args) {
		int[][] tab = new int[14][12];
		for(int j=0; j<tab.length; j++) {
			for(int i=0; i<tab[j].length; i++) {
				tab[j][i] = j+i+1; //en haut a  gauche
				//tab[j][i] = j+tab[j].length-1;  //en haut  a droite
				//tab[j][i] = tab.length - j+i; //en haut  a droite
				// tab[j][i] = tab.length - j + tab[j].length-i-1;  //en bas a droite
			}
		}
		
		System.out.println("taille de la première dimension du tableau (hauteur j) : "+tab.length);
		System.out.println("taille de la seconde dimension du tableau (largeur i)  : "+tab[0].length); // on donne  une valeur [j] pour avoir i

		// pour afficher tableau 2D
		
		for(int j=0; j<tab.length; j++) {
			for(int i=0; i<tab[j].length; i++) {
				if(tab[j][i] < 10)
					System.out.print("  " + tab[j][i]);
				else
					System.out.print(" " + tab[j][i]);
			}
			System.out.println();
		}
	}

}
