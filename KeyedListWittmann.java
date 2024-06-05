/**
 * 
 * @author Adam Wittmann <br>
 * 
 * Prog10Wittmann <br>
 * 
 * Purpose: This class stores and sorts PokemonWittmann instances.
 * 
 * Input: Nothing is inputed here.
 * 
 * Output: This class outputs the print list which prints the details for each Pokemon in the storage.
 * 
 * Certification of authenticity: <br>
 * I certify that this lab is entirely my own work.
 */

 /**
 * This class
 */
public class KeyedListWittmann {
	/**
	 * Instance variable myHead is the head node of the linked list
	 */
	private NodeWittmann myHead;
	/**
	 * Null constructor for KeyedListWittmann class
	 */
	public KeyedListWittmann() {

		myHead = null;

	}//null constructor

	/**
	 * addToList finds the correct index to insert a new pokemon instance.
	 * @param newPoke is the pokemon to be added to the lsit
	 * @return added, either true if the pokemon was successfully added or false if not.
	 */
	public boolean add(PokemonWittmann newPoke) {
		boolean found = false;
		NodeWittmann curr = myHead;
		NodeWittmann prev = null;
		NodeWittmann newNode = null;
		boolean added = false;
		//check for dupe
		if(retrieve(newPoke.getName()) == null) {
			newNode = new NodeWittmann(newPoke);
			added = true;
			while((curr != null)&&(found == false)) {
				if(newPoke.getName().compareToIgnoreCase(curr.getName()) < 0) {
					found = true;
				}//if
				else {
					prev = curr;
					curr = curr.getNext();
				}//else
			}//while
			//update references
			newNode.setNext(curr);
			if(prev == null) {
				myHead = newNode;
			}//if empty
			else{
				prev.setNext(newNode);
			}
		}
		return added;
		
	}//addToList
	/**
	 * remove finds the correct index to delete a pokemon associated with the user inputed name
	 * @param keyValue, user inputted name
	 * @return removed, either true if the Pokemon was successfully removed, or false if not.
	 */
	public boolean remove(String keyValue)
	{
		boolean removed = false;
		NodeWittmann curr = myHead;
		NodeWittmann prev = null;
		
		while((curr != null) && (removed == false)){
			if(curr.getName().equalsIgnoreCase(keyValue)) {
				removed = true;
			}//if
			else {
				prev = curr;
				curr = curr.getNext();
			}//else
		}//while
		
		//update references
		if(removed) {
			if(prev == null)
				myHead = curr.getNext();
			else 
				prev.setNext(curr.getNext());
		}//if
		return removed;
	}//remove
	/**
	 * retrieve Finds and returns the Pokemon associated with the user inputed name(if found).
	 * @param keyValue, user inputted name.
	 * @return
	 */
	public PokemonWittmann retrieve(String keyValue)
	{
		boolean found = false;
		NodeWittmann curr = myHead;
		PokemonWittmann ans = null;
		while((curr != null)&&(!found))
			{
				if(curr.getName().equalsIgnoreCase(keyValue)) {
					found = true;
					ans = curr.getData();
				}
				else {
					curr = curr.getNext();
				}
			}
		return ans;
	}//retrieve
	/**
	 * isEmpty Returns whether or not the array of pokemon is empty or not.
	 * @return empty, true if empty, false if not empty.
	 */
	public boolean isEmpty()
	{
		boolean empty = true;
		if(myHead != null) empty = false;
		return empty;
	}//isEmpty
	/**
	 * isFull Returns whether or not the array of Pokemon is full or not.
	 * @return full, true if full, false if not full.
	 */
	public boolean isFull()
	{
		boolean full = false;
		return full;
	}//ifFull
	/**
	 * Prints each pokemon in the array of pokemon
	 */
	public void print()
	{
		PokemonWittmann pokePrint = null;
		NodeWittmann curr = myHead;
		int i = 0;
		while((curr != null))
			{
				pokePrint = curr.getData();
				if(pokePrint != null)
				{
					System.out.println("--Pokemon "+ (i + 1) +"--\nPokemon Name:"+pokePrint.getName());
					System.out.println("Pokemon Multiplier: "+pokePrint.getMult());
					System.out.printf("Pokemon Power: %.2f",pokePrint.getPower());
					System.out.println();
				}//if
				curr = curr.getNext();
				i++;
			}//while
		
	}//print
	/**
	 * getTotalPower finds the sum of each Pokemon power in the array of Pokemon.
	 * @return sumPower, the sum of all Pokemon's power in the array of Pokemon.
	 */
	public double getTotalPower()
	{
		double sumPower = 0;
		NodeWittmann curr = myHead;
		double power = 0;
		while(curr != null) {
			power = curr.getData().getPower();
			sumPower += power;
			curr = curr.getNext();
		}
		return sumPower;
	}//getTotalPower
	/**
	 * calcBonusPower calculates the sum of each Pokemon's power, multiplied by their multiplier.
	 * @return extraPower, the sum of each Pokemon's power, multiplied by their multiplier.
	 */
	public double calcBonusPower()
	{
		double extraPower = 0;
		double power = 0;
		int multiplier = 0;
		NodeWittmann curr = myHead;
		while(curr != null)
		{
			power = curr.getData().getPower();
			multiplier = curr.getData().getMult();
			if(multiplier > 0)
			extraPower += power * multiplier;
			else extraPower += power;
			curr = curr.getNext();
		}//for i
		return extraPower;
	}//calcBonusPower
	/**
	 * clearPokemon, sets myPokes equal to a new instance of PokemonWittmann, clearing the previously inputed list.
	 */
	public void clearPokemon()
	{
		myHead = null;
	}//clearPokemon
}//KeyedListWittmann
