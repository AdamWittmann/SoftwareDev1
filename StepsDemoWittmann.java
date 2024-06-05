//Adam Wittmann
//Prog6Wittmann
//February 29, 2024
//This program takes user input to adjust characteristics of the steps and prints the drawing.
//input: Menu option, input Step Width, Number of Steps, and the Fill Style.
//Output: Outputs the drawing of the steps and text description of the steps(depending on what menu option user selects).
//I certify that this is entirely my own work.
import java.util.*;

public class StepsDemoWittmann {
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		StepsWittmann steps = new StepsWittmann();
		char choice = ' ';
		int stepWidth = 2;
		int numSteps = 5;
		char fillStyle = '*';
		String fillTemp = " ";
		int stepArea = 0;
		//Greeting
		System.out.println("Hello, welcome to steps.");
		System.out.println();
		//Print out basic steps
		steps.drawSteps();
		System.out.println();
		do
		{
			//Gather menu option selection from user.
			System.out.println("\nSelect an option:");
			System.out.println("'W' to Assign the Step Width.\n'N' to Assign the Number of Steps.\n'F' to Assign the Fill Style."
					+ "\n'A' To Calculate the Area.\n'T' For Text Description of the Steps.\n'D' To Draw Steps.\n'X' To Draw Thick Steps.\n'Q' To Quit.");
			choice = keyboard.next().toUpperCase().charAt(0);
			//user menu option input to switch case to select options
			switch(choice)
			{
			//Adjust Step Width
			case 'W':
				System.out.println("Assign the Step Width");
				System.out.println("Input Step Width:");
				stepWidth = keyboard.nextInt();
				while(stepWidth < 0)
				{
					System.out.println("Error: Step Width must be a positive integer.");
					System.out.println("Input Step Width:");
					stepWidth = keyboard.nextInt();
				}//while validation check, checks for negative integers
				steps.setStepWidth(stepWidth);
				break;
			//Adjust number of steps
			case 'N':
				System.out.println("Assign the number of steps");
				System.out.println("Input Number of Steps:");
				numSteps = keyboard.nextInt();
				while(numSteps < 0)
				{
					System.out.println("Error: Number of steps must be a positive integer");
					System.out.println("Input Number of Steps:");
					numSteps = keyboard.nextInt();
				}//while validation check, checks for negative integers
				steps.setNumSteps(numSteps);
				break;
			//Adjust the fill style
			case 'F':
				System.out.println("Assign the fill style");
				keyboard.nextLine();
				System.out.println("Input Fill Sytle:");
				fillTemp = keyboard.nextLine();
				fillStyle = fillTemp.charAt(0);
				steps.setFillStyle(fillStyle);
				break;
			//Calculate the area
			case 'A':
				System.out.println("Calculate the area");
				stepArea = steps.calcArea(numSteps, stepWidth);
				System.out.println("Step Area: " + stepArea);
				break;
			//Text Description
			case 'T':
				System.out.println("Text description of the steps:");
				System.out.println(steps.toString());
				stepArea = steps.calcArea(numSteps, stepWidth);
				System.out.println("Step Area: " + stepArea);
				break;
			//Draw Steps
			case 'D':
				System.out.println("Draw Steps");
				steps.drawSteps();
				break;
			//Draw Thick Steps
			case 'X':
				System.out.println("Draw Thick Steps");
				steps.drawThickSteps();
				break;
			//Quit
			case 'Q':
				System.out.println("Quit");
				break;
			//Default
			default:
				System.out.println("Error Try Again");
			}//Switch case
		}while(choice != 'Q');//Do While loop
		System.out.println("Goodbye");
	}//main

}//StepsDemoWittmann Class


