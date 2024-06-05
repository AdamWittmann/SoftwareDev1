//Adam Wittmann
//Prog2Wittmann
//02/08/2024
//THis program calculates the total cost of accommodation at a given hospital.
//Input: Patient ID, Household Income, Insurance plan, and the number of days stayed, can take multiple patients.
//output: Outputs total cost of stay, broken down into per diem, service fee, admittance fee, and the discount. Prints the number of patients, highest bill, patient id associated with the highest bill, total amount of all bills, and the average bill.
//I certify that this is entirely my own work, but I discussed it with Pedro Guitian.

import java.util.*;

public class HospitalWittmann {
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		//Initialize Variables
		int patientID = 0;
		char insurancePlan = 0;
		double householdIncome = 0;
		int numDays = 0;
		double perDiem = 0;
		double discount = 0;
		double totalBill = 0;
		String insuranceName = "";
		double serviceFee = 0;
		double ADMITTANCEFEE = 300;
		int numPatients = 0;
		double highestBill = 0;
		int highestBillID = 0;
		double totalBillSum = 0;
		double avgBill = 0;
		
		//Greeting
		System.out.println("This program calculates the total cost of your stay at a hospital.");
		System.out.println("Enter your patient ID, insurance plan, household income,\n and number of days spent at the hospital.");
		System.out.println("I will output the total dollar amount.");
		//Input ID
		System.out.println("Enter your patient ID:");
		patientID  = keyboard.nextInt();
		while(patientID != 0)
		{
			numPatients ++;
			System.out.println("Enter your household income:");
			householdIncome = keyboard.nextDouble();
			while(!(householdIncome >= 0))
			{
				System.out.println("Input invalid, please enter household income:");
				householdIncome = keyboard.nextDouble();
			}//while
			System.out.println("Enter your insurance provider:");
			System.out.println("'R' For Red Cross\n'M' For Mid-Hudson\n'A' For ACA\n'N' For No Insurance");
			insurancePlan = keyboard.next().charAt(0);
			//Validate insurance plan
			while(!((insurancePlan == 'r') || (insurancePlan == 'm') || (insurancePlan == 'a') || (insurancePlan == 'n') || (insurancePlan == 'R') || (insurancePlan == 'M') || (insurancePlan == 'A') || (insurancePlan == 'N')))
			{
				System.out.println("Invalid input");
				System.out.println("Enter a valid Insurance Plan:");
				System.out.println("'R' For Red Cross\n'M' For Mid-Hudson\n'A' For ACA\n'N' For No Insurance");
				insurancePlan = keyboard.next().charAt(0);
			}//while
			//Finding insurancePlan and perDiem
			switch (insurancePlan) {
			case 'r':
			case 'R': 
				insuranceName = "Red Cross";
				if (householdIncome <= 15000) {
					perDiem = 50;
				}//If
				else if (householdIncome <= 37500) {
					perDiem = 70;
				}//Else If
				else {
					perDiem = 150;
				}//else

				break;
			case 'm':
			case 'M': 
				insuranceName = "Mid-Hudson";
				if (householdIncome <= 20000) {
					perDiem = 40;
				}// if
				else if (householdIncome <= 45000) {
					perDiem = 75;

				}//else if
				else {
					perDiem = 100;
				}//else
				break;
			case 'a':
			case 'A' : 
				insuranceName = "ACA";
				if (householdIncome <= 12500) {
					perDiem = 60;
				}// if
				else if (householdIncome <= 53000) {
					perDiem = 75;

				}//else if
				else {
					perDiem = 140;
				}//else
				break;
			case 'n': 
			case 'N': 
				insuranceName = "No insurance";
				perDiem = 350;
				break;
			}//switch
			System.out.println("Enter number of days stayed:");
			numDays = keyboard.nextInt();
			while ((numDays < 1) || (numDays > 365)) {
				System.out.println("Number of days can only be within 1 and 365, please try again.");
				System.out.println("Enter number of days stayed:");
				numDays = keyboard.nextInt();
			}//while
			serviceFee = (numDays * perDiem);
			totalBill = serviceFee + ADMITTANCEFEE;
			//Calculates discount
			if (numDays > 23) {
				discount = (numDays / 7) * 250;
				totalBill = totalBill - discount;
			}//if
			//prints out the Patient ID number, Household Income, Insurance Plan, Number of Days, Admittance Fee, Per Diem Rate, Service Fee, Discount, and Total Bill
			System.out.println("Patient ID: " + patientID);
			System.out.printf("Household income: $%.2f", householdIncome);
			System.out.println("\nInsurancePlan: " + insuranceName);
			System.out.println("Number of days: "+ numDays);
			System.out.printf("Admittence Fee: $%.2f", ADMITTANCEFEE);
			System.out.printf("\nPer Diem Rate: $%.2f", perDiem);
			System.out.printf("\nService Fee: $%.2f", serviceFee);
			System.out.printf("\nDiscount: $%.2f ", discount);
			System.out.printf("\nThe total is $%.2f", totalBill);
			if(totalBill > highestBill)
			{
				highestBill = totalBill;
				highestBillID = patientID;
			}
			totalBillSum += totalBill;
			System.out.println("\nEnter Next Patient ID, 0 to quit:");
			patientID = keyboard.nextInt();
		}//while
		//Print summary data: Number of patients, highest bill, highest bill ID, total amount, and average bill.
		avgBill = totalBillSum/numPatients;
		System.out.println("Summary:");
		System.out.println("Number of patients: "+ numPatients);
		System.out.printf("Highest Bill paid: $%.2f",highestBill);
		System.out.println("\nPatient ID associated with highest bill:" + highestBillID);
		System.out.printf("Total amount of all bills processed: $%.2f", totalBillSum);
		System.out.printf("\nAverage bill amount: $%.2f", avgBill);
		System.out.println("\nGoodbye.");
	}//main

}//class
