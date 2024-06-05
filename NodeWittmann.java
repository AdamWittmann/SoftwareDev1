 /**
 * 
 */
public class NodeWittmann {
	/**
	 * Instance variable myData is the data associated with a specific node
	 */
	private PokemonCardWittmann myData;
	/**
	 * Instance variable myNext is the next node in the list.
	 */
	private NodeWittmann myNext;
	
	/**
	 * This is the null constructor for the nodeWittmann class.
	 */
	public NodeWittmann() {
		myData = null;
		myNext = null;
		
	}//null constructor
	/**
	 * This is the full constructor for the nodeWittmann class.
	 * @param newData, is the new data being inserted into the linked list.
	 */
	public NodeWittmann(PokemonCardWittmann newData) {
		myData = newData;
		myNext = null;
	}//full constructor
	/**
	 * setData sets the newData which is inputed by the user to the current node.
	 * @param newData, the new name, multiplier, and power being given to the current node.
	 */
	public void setData(PokemonCardWittmann newData) {
		myData = newData;
	}//setData
	/**
	 * setNext sets the next node in the list to a user inputed node reference.
	 * @param newNext, the user inputed node reference, to be the next in list.
	 */
	public void setNext(NodeWittmann newNext) {
		myNext = newNext;
	}//setNext
	/**
	 * getData returns the current name, multiplier and power to where its called.
	 * @return myData.
	 */
	public PokemonCardWittmann getData() {
		return myData;
	}//getData
	/**
	 * getName returns the name of the pokemon reference stored in the node.
	 * @return myData.getName
	 */
	public String getName() {
		return myData.getName();
	}//getData
	/**
	 * getNext returns the next node in the list.
	 * @return myNext, the next node in the list.
	 */
	public NodeWittmann getNext() {
		return myNext;
	}//getNext
	/**
	 *toString method. Prints the current data for the node and the next node in the list.
	 */
	public String toString() {
		return "myData: "+myData+"\nmyNext: "+myNext;
	}//toString
}//nodeWittmann
