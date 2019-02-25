
public class HappyNewYear {

	public static void main(String[] args) {
		

		System.out.println("Bonne annee 2019");
		
		//ex1: Écrire un algorithme qui déclare et remplisse un tableau de 8 valeurs numériques en les
		//mettant toutes à zéro
		
		
		int[] tab=new int [7];
		for(int i=0; i<tab.length;i++)
		{
			tab[i]=0;
			System.out.println(tab[i]);
		}
		
		//ex2:Écrire un algorithme qui déclare et remplisse un tableau contenant les noms des héros du
		//dessin animé l'age de glace : Scrat, Sid, Manny et Diego
		
//		ageDeGlace[] noms=ageDeGlace.values();
//		for(int i=0; i<noms.length; i++)
//		{
//			System.out.println(noms[i].name());
//		}
		
		String[] tabAge= {"Scrat", "Sid", "Manny", "Diego"};
		for(int i=0; i<tabAge.length;i++)
		{

			System.out.println(tabAge[i]);
		}
		
//		ex3:Écrire un algorithme qui déclare et remplisse un tableau contenant les noms et prénoms de
//		certains acteurs de starwars : Mark Hamill, Carrie Fisher, Harrison Ford, Alec Guinness.
//		Remarque : les noms et prénoms doivent être remplis dans un tableau multidimensionnel.
		
		
		String[][] tabStar=new String[3][3];
		
		
		
//		String [] prenomsActeurs= {"Mark","Carrie","Harrison","Alec"};
//		String [] nomsActeurs= {"Hamill","Fisher","Ford","Guinness"};
		
	}
}
