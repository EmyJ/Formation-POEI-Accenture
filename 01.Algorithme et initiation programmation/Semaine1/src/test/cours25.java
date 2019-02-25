// TP CORRECTION PALINDROME
package test;
import java.util.Scanner;
public class cours25 {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("saisissez un mot");
		char[] mot = scan.nextLine().toCharArray();
		scan.close();
		int i = 0;
		int j = mot.length - 1;
		while (i < j && mot[i] == mot[j]) {
			i++;
			j--;
		}
			if (i >= j)
				System.out.println("palindrome");
			else
				System.out.println("pas un palindrome");
		
	}
}