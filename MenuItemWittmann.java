
/**
 * @author Adam Wittmann <br>
 * 
 * Prog7Wittmann <br>
 * 
 * Purpose: This class creates instances of menu items that are created in main, but stored in OrderWittmann.
 * 
 * Input: There is no output
 * 
 * Output: This class outputs nothing except the to string
 * 
 * Certification of authenticity: <br>
 * I certify that this lab is entirely my own work.
 */

/**
 * This class handles the individual items within the order. Every instance variable here is stored in class OrderWittmann
 */
public class MenuItemWittmann {

	/**
	 * Instance variable myName, stores the name of the food item
	 */
	private String myName;

	/**
	 * Instance variable myQuant, stores the quantity of the item in users order.
	 */
	private int myQuant;

	/**
	 * Instance variable myPrice, stores the price of the item contained in the order.
	 */
	private double myPrice;

	/**
	 * Null constructor for MenuItemWittmann class
	 */
	public MenuItemWittmann() {
		myName = null;
		myQuant = 0;
		myPrice = 0.0;
	}//Null constructor


	/**
	 * Full constructor for MenuItemWittmann class
	 * @param newName, user input that gets assigned to myName
	 * @param newQuant, user input that gets assigned to myQuant
	 * @param newPrice, user input that gets assigned to myPrice
	 */
	public MenuItemWittmann(String newName, int newQuant, double newPrice) {
		myName = newName;
		myQuant = newQuant;
		myPrice = newPrice;

	}//Full constructor


	/**
	 * @return myName, returns the name of the food item
	 */
	public String getName() {
		return myName;
	}//getName


	/**
	 * @return myQuant, returns the quantity of the item in the order
	 */
	public int getQuant() {
		return myQuant;
	}//getQuant


	/**
	 * @return myPrice, returns the price of the item in the order
	 */
	public double getPrice() {
		return myPrice;
	}//getPrice


	/**
	 * This is the setter for myName
	 * @param newName this allows the user to set the instance variable myName
	 */
	public void setName(String newName) {
		myName = newName;
	}//setName


	/**This is the setter of myQuant
	 * @param newQuant this allows the user to set the instance variable myQuant
	 */
	public void setQuant(int newQuant) {
		myQuant = newQuant;
	}//setQuant


	/**This is the setter for myPrice
	 * @param newPrice this allows the user to set the instance variable myPrice
	 */
	public void setPrice(double newPrice) {
		myPrice = newPrice;
	}//setPrice


	/**
	 *This is the toString method, it prints out the current name, quantity, and price of food item
	 */
	public String toString() {

		return "Name: "+myName+" Quantity: "+myQuant+" Price: "+ String.format("$%.2f", myPrice);
	}//toString
}//MenuItemWittmann class
