 /**
 *  @author Adam Wittmann
 *  
 *  prog11Wittmann
 *  
 *  Purpose: This class constructs the stack.
 *  
 *  Input: No input
 *  
 *  Output: outputs nothing.
 *  
 *  Certificate of authenticity:
 *  I certify that this is entirely my own.
 */
 /**
 * StackWittmann constructs the stack of pokemon for the battle demo class.
 */
public class StackWittmann {
	/**
	 * Maximum size of the pokemon stack
	 */
	private static final int MAXSIZE = 52;
	/**
	 * Instance variable myPokes is the list of pokes
	 */
	private PokemonCardWittmann[] myPokes;
	/**
	 * the top of the list
	 */
	private int myTop;
	
	/**
	 * Null constructor for the StackWittmann
	 */
	public StackWittmann() {
		int i = 0;
		myPokes = new PokemonCardWittmann[MAXSIZE];
		myTop = -1;
		for(i = 0; i < MAXSIZE; i++) {
			myPokes[i] = null;
		}//for i
	}//null constructor
	
	/**
	 * push adds a Pokemon to the list
	 * @param newPoke the new poke to be added
	 * @return success, whether or not the Pokemon is added.
	 */
	public boolean push(PokemonCardWittmann newPoke) {
		boolean success = false;
		if(!isFull()) {
			myTop++;
			myPokes[myTop] = newPoke;
			success = true;
		}//if
		return success;
	}//push	
	/**
	 * Pop removes the top card of the stack
	 * @return popped, the card that is removed
	 */
	public PokemonCardWittmann pop() {
		PokemonCardWittmann popped = null;
		if(!isEmpty()) {
			popped = myPokes[myTop];
			myTop--;
		}//if
		return popped;
	}//pop
	/**
	 * isFull returns whether or not the list is full
	 * @return full, whether or not the list is full
	 */
	public boolean isFull() {
		boolean full = false;
		if(myTop == MAXSIZE - 1)full = true;
		return full;
	}//isFull
	/**
	 * isEmpty returns whether or not the list is empty
	 * @return empty, whether or not the list is empty
	 */
	public boolean isEmpty() {
		boolean empty = false;
		if(myTop == -1) {
			empty = true;
		}//if
		return empty;
	}//isEmpty
}//StackWittmann
