// IF - ELSE IF

package test;

import java.util.Scanner;

public class cours2 {

	public static void main(String[] args) {
		System.out.println("Saisissez votre temperature");
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();

		if (temp < 2) {
			System.out.println("verglas");
		} 
		else if (temp <15){
			System.out.println("froid");
		}
		else if (temp <30){
			System.out.println("O top !");
		}
		else if (temp >30){
			System.out.println("Canicule");
		}
		scan.close();
	}

}
