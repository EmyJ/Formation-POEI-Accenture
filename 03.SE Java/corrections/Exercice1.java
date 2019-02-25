package Exercices;

public class Exercice1 {

	public static void main(String[] args) {
		
		System.out.println("ex 1");
		//int[] tablo = { 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] tablo = new int[8];
		
		for (int j=0; j < tablo.length; j++) {
		tablo[j] =0;
		}
		for (int element : tablo) {
			System.out.println(element);
		}

		
	}
}