//Adam Wittmann
//Project 1 - Change Maker
//Due Date and Time: 1/25/2024

//Purpose: This program calculates the exact change you receive (bills and coins).
//Input: User inputs an amount
//I certify that this lab is entirely my own work.
import java.util.*;
public class ChangeMakerWittmann {
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args)
	{
		//declare and initialize variables
		int amount = 0;
		int originalAmount = 0;
		int twenties = 0;
		int tens = 0;
		int fives = 0;
		int singles = 0;
		int quarters = 0;
		int dimes = 0;
		int nickles = 0;
		int pennies = 1;
		
		//Greet user
		System.out.println("Welcome to the Change Maker system!");
		System.out.println("Enter an amount.");
		System.out.println("I will output a combination of bills and coins");
		System.out.println("that equals that amount of change.");
		
		//Grab the input
		
		System.out.println("\n Enter amount to be changed: ");
		amount = keyboard.nextInt();

		//calculate change
		originalAmount = amount;
		twenties = amount / 2000;
		amount = amount % 2000;
		tens = amount / 1000;
		amount = amount % 1000;
		fives = amount / 500;
		amount = amount % 500;
		singles = amount / 100;
		amount = amount % 100;
		quarters = amount / 25;
		amount = amount % 25;
		dimes = amount / 10;
		amount = amount % 10;
		nickles = amount / 5;
		amount = amount % 5;
		pennies = amount/1;
		
		//output results
		System.out.println(originalAmount + " change can be given as:");
		System.out.println(twenties + " twenties");
		System.out.println(tens + " tens");
		System.out.println(fives + " fives");
		System.out.println(singles + " singles");
		System.out.println(quarters + " quarters");
		System.out.println(dimes + " dimes");
		System.out.println(nickles + " nickles");
		System.out.println(pennies + " pennies");
		//Close scanner and print goodbye.
		keyboard.close();
		System.out.println("Goodbye.");
		}//Main

}//Class
