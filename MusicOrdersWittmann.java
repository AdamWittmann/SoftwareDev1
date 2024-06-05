//Adam Wittmann
//Prog4Wittmann
//This program calculates costs at a music store
//input: Customer ID, Customer name, number of songs, length of each song, and genre of each song
//Output: program outputs customer name, customer ID, number of songs purchased, the total cost of the songs, service charge, total amount due, total number of customers
//the highest amount charged, customer id with the highest amount, lowest amount charged, customer id with the lowest charge, total amount of all music purchased, and the average cost.
//I certify that this is entirely my own work.
import java.util.*;

public class MusicOrdersWittmann {
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		//Initialize variables in main
		int numCustomers = 0;
		double highestAmount = Integer.MIN_VALUE;
		int highestCustID = 0;
		double lowestAmount = Integer.MAX_VALUE;
		int lowestCustID = 0;
		double musicTotal = 0;
		double avgAmount = 0;
		
		int customerID = Integer.MIN_VALUE;
		do {
			String customerName = "";
			int numSongs = 0;
			double costAllSongs = 0;
			double serviceCharge = 0;
			double totalDue = 0;
			//Takes user input Customer ID, name, and number of songs ordered
			System.out.println("Enter Customer ID: ");
			customerID = keyboard.nextInt();
			
			if (customerID != 0)
			{
			numCustomers++;
			System.out.println("Enter Name: ");
			customerName = keyboard.next();
			System.out.println("Number of songs ordered: ");
			numSongs = keyboard.nextInt();
			while(numSongs <= 0)
			{
				System.out.println("Enter a positive value for number of songs: ");
				numSongs = keyboard.nextInt();
			}//while
			costAllSongs = chooseSongs(numSongs);

			serviceCharge = calcServiceCharge(numSongs, costAllSongs);

			totalDue = calcTotalDue(costAllSongs, serviceCharge);
			outputResults(customerName, customerID, numSongs, costAllSongs, serviceCharge, totalDue);
			if(totalDue > highestAmount)
			{
				highestAmount = totalDue;
				highestCustID = customerID;
			}//if
			if(totalDue < lowestAmount)
			{
				lowestAmount = totalDue;
				lowestCustID = customerID;
			}//if
			musicTotal += totalDue;
			}
		}while(customerID != 0);
		if(numCustomers > 0)
		avgAmount = musicTotal/numCustomers;
		else
			avgAmount = 0;
		if(highestAmount == Integer.MIN_VALUE)
			highestAmount = 0;
		if(lowestAmount == Integer.MAX_VALUE)
			lowestAmount = 0;
		System.out.println("Total Number of Customers: "+numCustomers);
		System.out.printf("Highest Amount Charged:$%.2f", highestAmount);
		System.out.println("\nCustomer ID associated with Highest Amount: "+highestCustID);
		System.out.printf("Lowest Amount Charged:$%.2f", lowestAmount);
		System.out.println("\nCustomer ID associated with the Lowest Amount: "+lowestCustID);
		System.out.printf("Total Amount of Music Purchased:$%.2f", musicTotal);
		System.out.printf("\nAverage of All Purchase Amounts:$%.2f", avgAmount);
		System.out.println("\nGoodbye!");
	}//main
public static double chooseSongs(int numOfSongs) {
	int songLength = 0;
	char genre = 0;
	double costPerSec = 0;
	double cost = 0;
	int i = 0;
	//do while loop start
	do {
	//i++ to keep track of how many songs.
	i++;
	System.out.println("Enter song length: ");
	songLength = keyboard.nextInt();
	//check valid input
	while((songLength < 1)||(songLength > 600))
	{
		System.out.println("Input invalid. Enter song length between 1 and 600 seconds:");
		songLength = keyboard.nextInt();
	}//while
	//User input song genre, validated data through while
	System.out.println("Choose song genre:");
	System.out.println("'P' for Pop\n'R' for Rap\n'C' for Country\n'G' for Gospel\n'O' for Other");
	genre = keyboard.next().charAt(0);
	while (!(genre == 'p' || genre == 'P' || genre == 'r' || genre == 'R' || genre == 'c' || genre == 'C' || genre == 'g' || genre == 'G' || genre == 'o' || genre == 'O')) 
		{
		System.out.println("Invalid input. Enter one of the following:");
		System.out.println("'P' for Pop\n'R' for Rap\n'C' for Country\n'G' for Gospel\n'O' for Other");
		genre = keyboard.next().charAt(0);
		}//while
		switch (genre) {
		case 'p':
		case 'P':
			costPerSec = .0035;
			break;
		case 'r':
		case 'R':
			costPerSec = .0054;
			break;
		case 'c':
		case 'C':
			costPerSec = .0025;
			break;
		case 'g':
		case 'G':
			costPerSec = .004;
			break;
		case 'o':
		case 'O':
			costPerSec = .003;
			break;
		}//switch
		
	cost += (costPerSec * songLength);
	}//do
	while(numOfSongs != i);
	return cost;
}//chooseSongs


//method calcServiceCharge takes the parameters: number of songs purchased and the cost of all songs, it calculates the service charge depending on how many songs were purchased
public static double calcServiceCharge(int numOfSongs, double total) {
	double servCharge = 0;
	if(numOfSongs >= 1 && numOfSongs <= 4)
		servCharge = total * .15;
	else if (numOfSongs >= 5 && numOfSongs <= 9)
		servCharge = total *.12;
	else if(numOfSongs >= 10 && numOfSongs <= 15)
		servCharge = total * .09;
	else if(numOfSongs > 15)
		servCharge = total *.06;
	return servCharge;
}//calcServiceCharge
//method calcTotalDue takes the total cost of songs and the service charge, the total amount due is calculated by multiplying the sum of cost and service charge by the tax of 8%. Total amount due is returned.
public static double calcTotalDue(double total, double servCharge) {
	double totalCost = (servCharge + total);
	double tax = totalCost * .08;
	return totalCost + tax;
}//calcTotalDue
//method outputResults prints the bill for the customer.
public static void outputResults(String custName, int custID, int numOfSongs, double total, double servCharge, double totalDue) {
	System.out.println("Customer Name: "+ custName);
	System.out.println("Customer ID: "+ custID);
	System.out.println("Number of songs purchased: "+ numOfSongs);
	System.out.printf("Total cost of songs:$%.2f", total);
	System.out.printf("\nService charge:$%.2f", servCharge);
	System.out.printf("\nTotal amount due:$%.2f\n", totalDue);
}//outputResults
}//class
