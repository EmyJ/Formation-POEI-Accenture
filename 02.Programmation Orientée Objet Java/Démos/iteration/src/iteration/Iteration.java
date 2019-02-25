package iteration;

public class Iteration {

	public static void main(String[] args) {
		//Différence entre ++i et i++
		//++i : la valeur de i est incrémenté avant son utilisation 
		//i++ : se sert d'abord de la valeur de i puis l'incrément ensuite
		int i = 12;
		System.out.printf("i=%d\n", ++i); // affiche 13
		int j = 12;
		System.out.printf("i=%d\n", j++); // affiche 12

	}

}
