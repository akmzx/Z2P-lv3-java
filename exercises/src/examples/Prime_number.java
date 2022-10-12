package examples;

import java.util.Scanner;

public class Prime_number {

	public static void main(String[] args) {
		
		int i = 2, n = 0;
		boolean flag = true;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		n = sc.nextInt();
		sc.nextLine();
		
		while(i <= n/2) {
			
			if(n%i == 0) {
				flag = false;
				break;
			} else {
				i++;
			}
		}
		
		if(!flag) {
			System.out.println(n + " is not a prime");
		}
		else {
			System.out.println(n + " is a prime");
		}
		
		sc.close();
	}
}
