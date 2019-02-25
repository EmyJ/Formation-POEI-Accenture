// IF - ELSE

package test;

import java.util.Scanner;

public class cours {

	public static void main(String[] args) {
System.out.println("Donnez votre temperature");
Scanner scan = new Scanner(System.in);
int temp = scan.nextInt();
scan.nextLine();

if (temp <2)
{
	System.out.println("verglas");
	}
else {
	System.out.println("super !");
}
scan.close();
	}
	
}
