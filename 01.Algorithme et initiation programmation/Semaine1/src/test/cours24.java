// palindrome
package test;
import java.util.Scanner;
public class cours24 {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int i, j;
		System.out.println("saisissez un palindrome");
		char[] mot = scan.nextLine().toCharArray();
		scan.close();
		j = mot.length - 1;
		boolean Palindrome =true;
		for (i = 0; i < mot.length / 2; i++) {
			if (mot[i] != mot [j]) {
				Palindrome= false;
			}
			j--;
		}
		if (Palindrome == true) {
			System.out.println("palindrome");
		}else 
			System.out.println("pas 1 palindrome");
	}
}