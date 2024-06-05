
/**
 * @author Adam Wittmann
 * 
 * Prog11Wittmann
 * 
 * Purpose: This class constructs the pokemon cards
 * 
 * input: nothing
 * 
 * Output: Nothing
 * 
 * Certificate of authenticity:
 * I certify that this is entirely my own work.
 */
/**
 * Constructs the cards
 */
public class PokemonCardWittmann {
	/**
	 * Instance variable myName is the name for the pokemon card
	 */
	private String myName;
	/**
	 * Instance variable myMulti is the pokemons multiplier
	 */
	private int myMulti;
	/**
	 * Instance variable myPower is the pokemons power level.
	 */
	private double myPower;
	
	/**
	 * Null constructor for the PokemonCardWittmann class
	 */
	public PokemonCardWittmann() {
		myName = null;
		myMulti = 0;
		myPower = 0.0;
	}//null constructor
	
	/**
	 * PokemonCardWittmann full constructor
	 * @param newName new name for the pokemon
	 * @param newMulti new multiplier for the pokemon
	 * @param newPower new power for the pokemon
	 */
	public PokemonCardWittmann(String newName, int newMulti, double newPower) {
		myName = newName;
		myMulti = newMulti;
		myPower = newPower;
	}//full constructor
	
	/**
	 * Sets the name
	 * @param newName the new name
	 */
	public void setName(String newName) {
		myName = newName;
	}//setName
	/**
	 * setMulti sets the multiplier
	 * @param newMulti the new multiplier
	 */
	public void setMulti(int newMulti) {
		myMulti = newMulti;
	}//setMulti
	/**
	 * setPower sets the new power for the pokemon
	 * @param newPower the new power
	 */
	public void setPower(double newPower) {
		myPower = newPower;
	}//setPower
	
	/**
	 * getName returns the name of the pokemon
	 * @return myName, the pokemons name
	 */
	public String getName() {
		return myName;
	}//getName
	/**
	 * getMulti returns the pokemons multiplier
	 * @return myMulti the pokemons multiplier
	 */
	public int getMulti() {
		return myMulti;
	}//getMulti
	/**
	 * getPower returns the power
	 * @return the pokemons power
	 */
	public double getPower() {
		return myPower;
	}//getPower
	
	/**
	 *toStrin method
	 */
	public String toString() {
		return myName + "/"+ myMulti+"/"+ myPower;
	}//toString
}//PokemonCardWittmann
