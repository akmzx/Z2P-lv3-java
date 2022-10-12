package examples;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		int first_temp = 0, second_temp = 1, temp;
		
		System.out.print(first_temp + ", " + second_temp);
		
		do {
			temp = second_temp;
			second_temp = second_temp + first_temp;
			first_temp = temp;
			
			if (second_temp > 1000) {
				break;
			}
			
			System.out.print(", " + second_temp);
		} while (second_temp <= 1000);
	}
}
