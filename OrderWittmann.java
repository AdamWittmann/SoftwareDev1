/**
 * @author Adam Wittmann <br>
 * 
 * Prog7Wittmann <br>
 * 
 * Purpose: This class stores the items from MenuItemWittmann in an array.
 * 
 * Input: Nothing is inputed here
 * 
 * Output: This class outputs the print list which prints the to string for each item in the order
 * 
 * Certification of authenticity: <br>
 * I certify that this lab is entirely my own work.
 */

/**
 * This class stores the menu items and contains methods that return items for the menu options
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class OrderWittmann {
	static Scanner keyboard = new Scanner(System.in);
	/**
	 * Instance array myMenuItems, defines an instance array that will store menu items from MenuItemWittmann class
	 */
	private MenuItemWittmann [] myMenuItems;
	/**
	 * Instance variable mySize, keeps track of the size of the array.
	 */
	private int mySize;
	
	/**
	 * Null constructor for instance variables, creates and initializes values.
	 */
	public OrderWittmann() {
		myMenuItems = new MenuItemWittmann [8];
		mySize = 0;
		int i = 0;
		for(i = 0; i < myMenuItems.length; i++) {
			myMenuItems[i] = null;
		}//for i
	}//null constructor
	/**
	 * returns the size of the array
	 * @return mySize, the number of items currently in the order.
	 */
	public int getSize() {
		return mySize;
	}//getSize
	/**
	 * addToOrder attempts to add an item, from user in main, to the array. If its successful it returns true.
	 * @param item Food item that is to be added to the order
	 * @return added, returns whether or not the item was added to the order
	 */
	public boolean addToOrder(MenuItemWittmann item) {
		boolean added = false;
		if(mySize < myMenuItems.length) {
			myMenuItems[mySize] = item;
			if((item.getPrice() < 0)||(item.getQuant() < 0)){
				System.out.println("Item Price or Quant cannot be negative");
			}
			else
			added = true; 
			mySize ++;
		}//if
		return added;
	}//addToORder Method
	
	
	/**
	 * Finds and returns the most expensive item that appears in the order array
	 * @return mostExpensive, the most expensive item that appears in the order array
	 */
	public MenuItemWittmann findMostExpensive() {
		int i = 0;
		MenuItemWittmann mostExpensiveItem = null;
		double highPrice = Double.MIN_VALUE;
		for(i = 0; i < mySize; i++) {
			if(highPrice < myMenuItems[i].getPrice()) {
				mostExpensiveItem = myMenuItems[i];
				highPrice = myMenuItems[i].getPrice();
			}//if
		}//for i
		return mostExpensiveItem;
	}//findMostExpensive Method
	
	
	/**
	 * Finds and returns the most expensive item that appears in the order array
	 * @return leastExpensive, the least expensive item that appears in the order array
	 */
	public MenuItemWittmann findLeastExpensive() {
		int i = 0;
		MenuItemWittmann lowestPrice = null;
		double lowPrice = Double.MAX_VALUE;
		for(i = 0; i < mySize; i++) {
			if(lowPrice > myMenuItems[i].getPrice()) {
				lowestPrice = myMenuItems[i];
				lowPrice = myMenuItems[i].getPrice();
			}//if
		}//for i
		return lowestPrice;
	}//findLeastExpensive method
	
	
	/**
	 * This method calculates the total price for the order array.
	 * @return total, the total price for the order (Each items price multiplied by its quantity)
	 */
	public double calcTotal() {
		double total = 0;
		int i = 0;
		for(i = 0; i < mySize; i++) {
			total += myMenuItems[i].getPrice() * myMenuItems[i].getQuant();
		}//for i
		return total;
	}//calcTotal method
	
	
	/**
	 * Returns the total quantity of the entire order array.
	 * @return totalQuant, the total quantity of the entire order array
	 */
	/**
	 * @return
	 */
	public int calcQuant() {
		int totalQuant = 0;
		int i = 0;
		for(i = 0; i< mySize; i++) {
			totalQuant += myMenuItems[i].getQuant();
		}//for i
		return totalQuant;
	}//calcQuant method
	
	
	/**
	 * This method removes the most expensive menu item that appears in the order array
	 * @param target, is the most expensive item in the array, the target being removed
	 * @return removed, the removed item
	 */
	public MenuItemWittmann removeMostExpensive(MenuItemWittmann target) {
		MenuItemWittmann removed = null;
		int i = 0;
		while((i < mySize) && (removed == null)) {
			if(target == myMenuItems[i]) {
				removed = myMenuItems[i];
			}//if
			else i++;
		}//while
		if(removed != null) {
			myMenuItems[i] = myMenuItems[mySize - 1];
			mySize--;
		}//delete most expensive. If
		return removed;
	}//removeMostExpensive method
	
	
	/**
	 * PrintList labels and prints out each items 'to string'
	 */
	public void printList() {
		int i = 0;
		for(i = 0; i < mySize; i++) {
			double price = myMenuItems[i].getPrice();
			System.out.println("Menu Item " + (i+1) + ":");
			System.out.printf("Item name: "+ myMenuItems[i].getName() + " Quantity: " + myMenuItems[i].getQuant() + " Price: $%.2f", price);
			System.out.println();
		}//for i
	}//printList method
	
}//OrderWittmann class
