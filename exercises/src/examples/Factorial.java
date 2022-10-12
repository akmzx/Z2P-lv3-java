package examples;

import java.util.Scanner;

public class Factorial {
	
	public static void main(String[] args) {
		
		int i = 1;
		
		int factorial = 1;
		
		int n;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number: ");
		n = sc.nextInt();
		sc.nextLine();
		
		while(i < n) {
			factorial = factorial * i;
			i++;
		}
		System.out.println("Factorial = " + factorial);
		sc.close();
	}
}
