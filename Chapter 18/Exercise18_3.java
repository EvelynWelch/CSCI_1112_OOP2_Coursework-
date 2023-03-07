// author: Evie Welch
// date 03/06/23

import java.util.Scanner;

public class Exercise18_3 {
	
	public static int gcd(int m, int n) {
		int r = m % n;
		if(r == 0) {
			return n;
		} else {
			return gcd(n, r);
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Find the greatest common divisor of two numbers.");
		System.out.print("Enter number 1: ");
		int m = input.nextInt();
		System.out.print("Enter number 2: ");
		int n = input.nextInt();
		input.close();
		System.out.printf("The greatest common divisor of %d, and %d is %d", m , n, gcd(m,n));
		
	}

}
