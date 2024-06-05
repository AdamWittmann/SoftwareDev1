/**
 * 
 * @author Adam Wittmann <br>
 * 
 * Prog10Wittmann <br>
 * 
 * Purpose: This class constructs Pokemon to be stored in the KeyedListWittmann class
 * 
 * Input: Nothing is inputed here.
 * 
 * Output: This class prints nothing
 * 
 * Certification of authenticity: <br>
 * I certify that this lab is entirely my own work.
 */

/**
 * This class takes the user input for a new pokemon from main and creates the instance to be stored in the KeyedListWittmann class.
 */
public class PokemonWittmann {
	/**
	 * Instance variable myName is the name associated with the current pokemon instance.
	 */
	private String myName;
	/**
	 * Instance variable myMult is the multiplier associated with the current pokemon instance.
	 */
	private int myMult;
	/**
	 * Instance variable myPower is the power associated with the current pokemon instance.
	 */
	private double myPower;
	
	/**
	 * null constructor for PokemonWittmann, initializes values.
	 */
	public PokemonWittmann() {
		myName = null;
		myMult = 0;
		myPower = 0;
	}//null constructor
	
	/**
	 * Full constructor for the PokemonWittmann class
	 * @param newName, the new name from user to be set to the current pokemon instance.
	 * @param newMult the new multiplier from user to be set to the current pokemon instance.
	 * @param newPower the new power from user to be set to the current pokemon instance.
	 */
	public PokemonWittmann(String newName, int newMult, double newPower) {
		myName = newName;
		myMult = newMult;
		myPower = newPower;
	}//full constructor
	
	/**
	 * getName returns the name of the current pokemon instance.
	 * @return myName, the name of the current pokemon instance.
	 */
	public String getName() {
		return myName;
	}//getName
	/**
	 * getMult returns the multiplier of the current pokemon instance.
	 * @return myMult, the multiplier of the current pokemon instance.
	 */
	public int getMult() {
		return myMult;
	}//getMult
	/**
	 * getPower returns the power of the current pokemon instance.
	 * @return myPower, the power of the current pokemon instance.
	 */
	public double getPower() {
		return myPower;
	}//getPower
	/**
	 * setName sets the new name to the current pokemon instance.
	 * @param newName, is the new name being set to the current pokemon instance.
	 */
	public void setName(String newName) {
		myName = newName;
	}//setName
	/**
	 * setMult sets the new multiplier to the current pokemon instance.
	 * @param newMult, is the new multiplier being set to the current pokemon instance.
	 */
	public void setMult(int newMult) {
		myMult = newMult;
	}//setMult
	/**
	 * setPower sets the new power to the current pokemon instance.
	 * @param newPower, is the power being set to the current pokemon instance.
	 */
	public void setPower(double newPower) {
		myPower = newPower;
	}//setPower
	/**
	 *toString prints out the current values of the instance variables: myName, myMult, myPower.
	 */
	public String toString() {
		return "myName: " + myName + "\nmyMult: " + myMult + "\nmyPower: " + myPower;
	}//toString
}//PokemonWittmann
