/*
Name: Assignment 1
Author: Henzi Kou
 */

import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num1 = 0;
		int sum = 0;		
		boolean running = true;
			
		while (running) {
			System.out.println("Enter p to print, r to reset, q to quit, and i to add an integer: ");
			String command = input.next();
			
			if (command.equals("p")) {
				System.out.printf("Sum: %d%n", sum);
			}
			else if (command.equals("r")) {
				sum = 0;
				System.out.printf("Sum: %d%n", sum);
			}
			else if (command.equals("i")) {
				System.out.println("Enter the integer: ");
				num1 = input.nextInt();
				sum = sum + num1;
			}
			else if (command.equals("q")) {
				System.out.printf("Sum is: %d%n", sum);
				running = false;
			}
		}
	}
}
