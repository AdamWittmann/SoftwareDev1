/**
 * @author Adam Wittmann
 * Prog7Wittmann
 * Due Date: 3/21/24 before 9am
 * 
 * purpose: This program keeps track of a fast food order.
 * input: the input of the program will be the menu options and the items in the order
 *
 * output: this program returns the most expensive item, least expensive item, total quantity within the order, total cost of the order
 * and details about all menu items in the order.
 * I certify that this program is entirely my own work.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OrderDemoWittmann {
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		//initialize variables
		OrderWittmann myOrder = new OrderWittmann();
		String name;
		int quant = 0;
		double price = 0;
		char choice = 0;
		boolean foodAdded = false;
		MenuItemWittmann mostExpensive = null;
		MenuItemWittmann leastExpensive = null;
		MenuItemWittmann foodItem = new MenuItemWittmann();
		int orderSize = 0;
		int i = 0;
		boolean added = false;
		String fileName = null;

		System.out.println("Welcome. This program handles a fast food like order.");
		
		do {
			//print menu options
			System.out.println("A – Add a MenuItem to the Order\n"
					+ "L – Find the Least Expensive MenuItem in the Order\n"
					+ "M – Find the Most Expensive MenuItem in the Order\n"
					+ "N – Find the number of MenuItems in the Order\n"
					+ "T – Find the total cost of all MenuItems in the Order\n"
					+ "P – Print out details about all MenuItems in the Order\n"
					+ "D – Delete the Most Expensive MenuItem from the Order\n"
					+ "I - Import Order\n"
					+ "Q - Quit");
			//receive user input
			choice = keyboard.next().toUpperCase().charAt(0);
			//decide which menu option to select based on user input
			switch(choice) {
			case 'A':
				System.out.println("Add Item");
				System.out.println("Enter item name: ");
				name = keyboard.next();
				
				System.out.println("Enter item quantity: ");
				quant = keyboard.nextInt();
				while(quant < 0) {
					System.out.println("Quantity cannot be negative\nEnter item quantity: ");
					quant = keyboard.nextInt();
				}
				System.out.println("Enter item price: ");
				price = keyboard.nextDouble();
				while(price < 0) {
					System.out.println("Price cannot be negative\nEnter item price: ");
					price = keyboard.nextDouble();
				}
				
				
				MenuItemWittmann grub = new MenuItemWittmann(name, quant, price);
				
				foodAdded = myOrder.addToOrder(grub);
				if(foodAdded) {
					System.out.println(name+ " Successfully added to order.");
				}//if
				else System.out.println("Order Full. "+ name +" not added to order.");
				break;
				
			case 'L':
				leastExpensive = myOrder.findLeastExpensive();
				if(leastExpensive == null) System.out.println("No items in order.");
				else System.out.println("Least expensive item in order: "+ leastExpensive);
				break;
				
			case 'M':
				mostExpensive = myOrder.findMostExpensive();
				if(mostExpensive == null) System.out.println("No items in order.");
				else System.out.println("Most expensive item in order: "+ mostExpensive);
				break;
				
			case 'N':
				System.out.println("Total number of items in order: "+myOrder.calcQuant());
				break;
				
			case 'T':
				System.out.printf("Total cost: $%.2f",myOrder.calcTotal());
				System.out.println();
				break;
				
			case 'P':
				myOrder.printList();
				break;
				
			case 'D':
				mostExpensive = myOrder.findMostExpensive();
				if(mostExpensive == null)System.out.println("No Items in Order.");
				else System.out.println("Removed: " + myOrder.removeMostExpensive(mostExpensive));
				break;
				
			case 'Q':
				System.out.println("Quit.");
				break;
			case 'I':
				System.out.println("Input Order.");
				System.out.println("Enter a filename: ");
				fileName = keyboard.next();
				File inputFile = new File(fileName);
				//try to input file
				try
				{
					Scanner input = new Scanner(inputFile);
					orderSize = input.nextInt();
					for(i = 0; i < orderSize; i++) {
						name = input.next();
						quant = input.nextInt();
						price = input.nextDouble();
						foodItem = new MenuItemWittmann(name, quant, price);
						added =  myOrder.addToOrder(foodItem);
					}//for i
					input.close();
				}//try
				catch(FileNotFoundException ex)
			    {
				      System.out.println("Failed to find file: " + inputFile.getAbsolutePath()); 
				    }//catch
				    catch(InputMismatchException ex)
				    {
				    	System.out.println("Type mismatch for the number I just tried to read.");
				        System.out.println(ex.getMessage());
				    }//catch
				    catch(NumberFormatException ex)
				    {
				      System.out.println("Failed to convert String text into an integer value.");
				      System.out.println(ex.getMessage());
				    }//catch
				    catch(NullPointerException ex)
				    {
				      System.out.println("Null pointer exception.");
				      System.out.println(ex.getMessage());
				    }//catch
				    catch(Exception ex)
				    {
				      // Like an "else" catch(Exception should come last as the catchall.
				    	System.out.println("Something went wrong");
				      ex.printStackTrace();
				    }//catch
				break;
			default:
				System.out.println("Error. Try Again.");
			}//case switch
		}while(choice != 'Q');
		System.out.println("Goodbye.");
	}//Main

	
}//OrderDemoWittmann class
