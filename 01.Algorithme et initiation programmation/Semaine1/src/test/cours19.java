// TABLEAUX

package test;

public class cours19 {

	public static void main(String[] args) {
		// creation d'un tableau de 10 cases
		int[] tableau = new int[10];
		// affectation d'une valeur dans la case d'indice 2 du tableau (la 3e case du tableau)
		tableau[2]= 4785;
		System.out.println("dans la case d'indice 2 du tableau, il y a " + tableau[2]);
		System.out.println("le tableau a " + tableau.length + " cases");
		
		//parcours de l'ensemble du tableau
		for (int element : tableau) {
			System.out.println(element);
			}
		//parcours avec l'indice
		for (int indice=0; indice<tableau.length; indice++) {
			System.out.println("dans la case d'indice " + indice + " du tableau, il y a " + tableau[indice]);
		}	
		char[] mot = {'b','o','n','j','o','u','r'};
		System.out.println();
		for (char element : mot) {
			System.out.println(element);
			}
	}

}
